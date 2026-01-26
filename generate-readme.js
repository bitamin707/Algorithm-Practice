const fs = require("fs");
const path = require("path");

const BASE_DIR = "./src";
const JAVA_DIR = path.join(BASE_DIR, "main", "java");
const TEST_DIR = path.join(BASE_DIR, "test", "java");

// Javadoc 주석 파싱용 정규식
const JAVADOC_TITLE = /\*\s*제목\s*[:：]\s*(.+)/;
const JAVADOC_DIFFICULTY = /\*\s*난이도\s*[:：]\s*(.+)/;
const JAVADOC_LINK = /\*\s*링크\s*[:：]\s*(.+)/;

// 마크다운 테이블 헤더
const headers = {
    baekjoon: `| 난이도 | 문제 번호 | 제목 | 코드 | 테스트 | 링크 |\n|--------|-----------|------|------|--------|---|`,
    programmers: `| 난이도 | 제목 | 코드 | 테스트 | 링크 |\n|--------|------|------|--------|---|`
};

// 백준 난이도 계층 및 정렬용 가이드
const BOJ_TIERS = ["플래티넘", "골드", "실버", "브론즈", "언랭크"];
const BOJ_DIFFICULTY_TIER_MAP = {
    "플래티넘": 5,
    "골드": 4,
    "실버": 3,
    "브론즈": 2,
    "언랭크": 1,
    "❓": 0
};

// 난이도 정렬 키 추출
function parseDifficulty(difficultyStr, platform) {
    if (platform === "programmers") {
        const levelMatch = difficultyStr.match(/Level\s*(\d+)/i);
        return { tier: 1, level: parseInt(levelMatch?.[1] || "0") };
    }
    const parts = difficultyStr.trim().split(" ");
    const main = parts[0];
    const sub = parseInt(parts[1]) || 0;
    return {
        tier: BOJ_DIFFICULTY_TIER_MAP[main] || 0,
        level: sub
    };
}

// 하위 폴더까지 모든 자바 파일을 찾는 재귀 함수
const getAllJavaFiles = (dirPath, arrayOfFiles) => {
    if (!fs.existsSync(dirPath)) return arrayOfFiles || [];
    const files = fs.readdirSync(dirPath);
    arrayOfFiles = arrayOfFiles || [];

    files.forEach((file) => {
        const fullPath = path.join(dirPath, file);
        if (fs.statSync(fullPath).isDirectory()) {
            arrayOfFiles = getAllJavaFiles(fullPath, arrayOfFiles);
        } else if (file.endsWith(".java")) {
            arrayOfFiles.push(fullPath);
        }
    });

    return arrayOfFiles;
};

// 백준 테이블 생성 (난이도별 그룹화)
const generateBaekjoonSection = () => {
    const mainDir = path.join(JAVA_DIR, "baekjoon");
    const testDir = path.join(TEST_DIR, "baekjoon");
    const allFiles = getAllJavaFiles(mainDir);
    const rows = [];

    allFiles.forEach(filePath => {
        const content = fs.readFileSync(filePath, "utf-8");
        const difficulty = (content.match(JAVADOC_DIFFICULTY) || [])[1] || "❓";
        const title = (content.match(JAVADOC_TITLE) || [])[1] || "제목 없음";
        const problemLink = (content.match(JAVADOC_LINK) || [])[1] || "#";

        const fileName = path.basename(filePath, ".java");
        const id = (fileName.match(/\d+/) || [""])[0];
        
        // 상대 경로를 이용해 테스트 코드 경로 매칭
        const relativePath = path.relative(mainDir, filePath);
        const testFilePath = path.join(testDir, relativePath.replace(fileName + ".java", fileName.replace("_", "") + "Test.java"));

        rows.push({
            difficulty,
            tierName: difficulty.split(" ")[0],
            difficultySortKey: parseDifficulty(difficulty, "baekjoon"),
            id,
            title,
            codeLink: `[코드](./${filePath.replace(/\\/g, "/")})`,
            testLink: fs.existsSync(testFilePath) ? `[테스트](./${testFilePath.replace(/\\/g, "/")})` : "❌",
            link: `[문제 링크](${problemLink})`
        });
    });

    // 티어별 그룹화
    const grouped = rows.reduce((acc, row) => {
        const tName = BOJ_TIERS.includes(row.tierName) ? row.tierName : "기타";
        if (!acc[tName]) acc[tName] = [];
        acc[tName].push(row);
        return acc;
    }, {});

    let markdown = "## ✅ 백준 (Baekjoon)\n\n";
    BOJ_TIERS.concat("기타").forEach(tier => {
        if (!grouped[tier] || grouped[tier].length === 0) return;
        
        // 그룹 내에서 레벨 오름차순 (1 -> 5)
        grouped[tier].sort((a, b) => a.difficultySortKey.level - b.difficultySortKey.level);

        markdown += `### ${tier}\n\n${headers.baekjoon}\n`;
        grouped[tier].forEach(row => {
            markdown += `| ${row.difficulty} | ${row.id} | ${row.title} | ${row.codeLink} | ${row.testLink} | ${row.link} |\n`;
        });
        markdown += "\n";
    });

    return markdown;
};

// 프로그래머스 테이블 생성 (기존 로직 유지)
// 프로그래머스 테이블 생성
const generateProgrammersSection = () => {
    const mainDir = path.join(JAVA_DIR, "programmers");
    const testDir = path.join(TEST_DIR, "programmers"); // 테스트 디렉토리 추가

    if (!fs.existsSync(mainDir)) return "";

    const files = fs.readdirSync(mainDir).filter(f => f.endsWith(".java"));
    const rows = files.map(file => {
        const filePath = path.join(mainDir, file);
        const content = fs.readFileSync(filePath, "utf-8");
        const difficulty = (content.match(JAVADOC_DIFFICULTY) || [])[1] || "❓";
        const title = (content.match(JAVADOC_TITLE) || [])[1] || "제목 없음";
        const problemLink = (content.match(JAVADOC_LINK) || [])[1] || "#";

        const fileName = path.basename(file, ".java");
        // PG_1844 -> PG1844Test.java 형식으로 변환
        const testFileName = fileName.replace(/_/g, "") + "Test.java";
        const testFilePath = path.join(testDir, testFileName);

        return {
            difficulty,
            difficultySortKey: parseDifficulty(difficulty, "programmers"),
            title,
            codeLink: `[코드](./${filePath.replace(/\\/g, "/")})`,
            // 테스트 파일 존재 여부 확인
            testLink: fs.existsSync(testFilePath)
                ? `[테스트](./${testFilePath.replace(/\\/g, "/")})`
                : "❌",
            link: `[문제 링크](${problemLink})`
        };
    });

    // 난이도(Level) 내림차순 정렬
    rows.sort((a, b) => b.difficultySortKey.level - a.difficultySortKey.level);

    let markdown = "## ✅ 프로그래머스 (Programmers)\n\n" + headers.programmers + "\n";
    rows.forEach(row => {
        markdown += `| ${row.difficulty} | ${row.title} | ${row.codeLink} | ${row.testLink} | ${row.link} |\n`;
    });
    return markdown;
};

const generateReadme = () => {
    const intro = `# 알고리즘 문제 풀이 저장소 (Java + JUnit)
📘 백준(BOJ), 프로그래머스(Programmers) 등에서 푼 알고리즘 문제를 기록합니다.

📌 Java 기반, 테스트는 JUnit 사용
📂 난이도별 디렉토리 구조 유지 + 문제 설명 및 풀이 전략 포함

## 🔥 문제 풀이 목록
`;

    const result = [intro, generateBaekjoonSection(), generateProgrammersSection()].join("\n");

    fs.writeFileSync("README.md", result);
    console.log("✅ README.md 파일이 성공적으로 생성되었습니다.");
};

generateReadme();