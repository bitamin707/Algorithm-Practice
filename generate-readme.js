const fs = require("fs");
const path = require("path");

const BASE_DIR = "./src";
const JAVA_DIR = path.join(BASE_DIR, "main", "java");
const TEST_DIR = path.join(BASE_DIR, "test", "java");

const PLATFORMS = {
    baekjoon: "baekjoon",
    programmers: "programmers"
};

// Javadoc 주석 파싱용 정규식
const JAVADOC_TITLE = /\*\s*제목\s*[:：]\s*(.+)/;
const JAVADOC_DIFFICULTY = /\*\s*난이도\s*[:：]\s*(.+)/;
const JAVADOC_LINK = /\*\s*링크\s*[:：]\s*(.+)/;

// 마크다운 테이블 헤더
const headers = {
    baekjoon: `| 난이도 | 문제 번호 | 제목 | 코드 | 테스트 | 링크 |
|--------|-----------|------|------|--------|---|`,
    programmers: `| 난이도 | 제목 | 코드 | 테스트 | 링크 |
|--------|------|------|--------|---|`
};

// 백준 난이도 계층
const BOJ_DIFFICULTY_TIER = {
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
        return {
            tier: 1,
            level: parseInt(levelMatch?.[1] || "0")
        };
    }

    // 백준
    const parts = difficultyStr.trim().split(" ");
    const main = parts[0];
    const sub = parseInt(parts[1]) || 0;
    return {
        tier: BOJ_DIFFICULTY_TIER[main] || 0,
        level: sub
    };
}

// 테이블 행 생성
const generateTableRows = (platform) => {
    const dirPath = path.join(JAVA_DIR, platform);
    const testDirPath = path.join(TEST_DIR, platform);
    const rows = [];

    const files = fs.readdirSync(dirPath).filter(f => f.endsWith(".java"));
    files.forEach(file => {
        const filePath = path.join(dirPath, file);
        const content = fs.readFileSync(filePath, "utf-8");

        const title = (content.match(JAVADOC_TITLE) || [])[1] || "제목 없음";
        const difficulty = (content.match(JAVADOC_DIFFICULTY) || [])[1] || "❓";
        const problemLink = (content.match(JAVADOC_LINK) || [])[1] || "#";

        const fileName = path.basename(file, ".java");
        const idMatch = fileName.match(/\d+/);
        const id = idMatch ? idMatch[0] : "";
        const testFileName = fileName.replace("_", "") + "Test.java";
        const testFilePath = path.join(testDirPath, testFileName);

        const codeLink = `[코드](./${filePath.replace(/\\/g, "/")})`;
        const testLink = fs.existsSync(testFilePath)
            ? `[테스트](./${testFilePath.replace(/\\/g, "/")})`
            : "❌";
        const link = `[문제 링크](${problemLink})`;

        const difficultySortKey = parseDifficulty(difficulty, platform);

        const row = {
            difficulty,
            difficultySortKey,
            id,
            title,
            codeLink,
            testLink,
            link
        };

        rows.push(row);
    });

    // 정렬: 플랫폼별 분리 기준
    rows.sort((a, b) => {
        const aDiff = a.difficultySortKey;
        const bDiff = b.difficultySortKey;

        if (platform === "programmers") {
            return bDiff.level - aDiff.level;
        }

        if (aDiff.tier !== bDiff.tier) {
            return bDiff.tier - aDiff.tier;
        }
        return aDiff.level - bDiff.level;
    });

    const formattedRows = rows.map(row => {
        if (platform === "baekjoon") {
            return `| ${row.difficulty} | ${row.id} | ${row.title} | ${row.codeLink} | ${row.testLink} | ${row.link} |`;
        } else {
            return `| ${row.difficulty} | ${row.title} | ${row.codeLink} | ${row.testLink} | ${row.link} |`;
        }
    });

    return [headers[platform], ...formattedRows].join("\n");
};

// README.md 생성
const generateReadme = () => {
    const intro = `# 알고리즘 문제 풀이 저장소 (Java + JUnit)
📘 백준(BOJ), 프로그래머스(Programmers) 등에서 푼 알고리즘 문제를 기록합니다.

📌 Java 기반, 테스트는 JUnit 사용

📂 문제별 디렉토리 구조 유지 + 문제 설명 및 풀이 전략 포함

## 🔥 문제 풀이 목록
`;

    const baekjoonSection = `### ✅ 백준 (Baekjoon)\n\n${generateTableRows("baekjoon")}`;
    const programmersSection = `### ✅ 프로그래머스 (Programmers)\n\n${generateTableRows("programmers")}`;

    const result = [intro, baekjoonSection, "", programmersSection].join("\n\n");

    fs.writeFileSync("README.md", result);
    console.log("✅ README.md 파일이 성공적으로 생성되었습니다.");
};

generateReadme();
