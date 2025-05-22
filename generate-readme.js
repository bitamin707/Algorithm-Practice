const fs = require("fs");
const path = require("path");

// 디렉토리 경로 설정
const BASE_DIR = "./src";
const JAVA_DIR = path.join(BASE_DIR, "main", "java");
const TEST_DIR = path.join(BASE_DIR, "test", "java");

const PLATFORMS = {
    baekjoon: "baekjoon",
    programmers: "programmers"
};

// 정규식: Javadoc 스타일 주석 파싱
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

// 난이도 우선 순위 정렬
const DIFFICULTY_ORDER = {
    "Level 5": 5,
    "Level 4": 4,
    "Level 3": 3,
    "Level 2": 2,
    "Level 1": 1,
    "플래티넘": 5,
    "골드": 4,
    "실버": 3,
    "브론즈": 2,
    "❓": 0
};

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
        const id = fileName.match(/\d+/)?.[0] || "";
        const testFileName = fileName.replace("_", "") + "Test.java";
        const testFilePath = path.join(testDirPath, testFileName);

        const codeLink = `[코드](./${filePath.replace(/\\/g, "/")})`;
        const testLink = fs.existsSync(testFilePath)
            ? `[테스트](./${testFilePath.replace(/\\/g, "/")})`
            : "❌";
        const link = `[문제 링크](${problemLink})`;

        if (platform === "baekjoon") {
            rows.push([difficulty, id, title, codeLink, testLink, link]);
        } else {
            rows.push([difficulty, title, codeLink, testLink, link]);
        }
    });

    // 난이도 내림차순 정렬
    rows.sort((a, b) => {
        const aVal = DIFFICULTY_ORDER[a[0].split(" ")[0]] || 0;
        const bVal = DIFFICULTY_ORDER[b[0].split(" ")[0]] || 0;
        return bVal - aVal;
    });

    return [headers[platform], ...rows.map(r => `| ${r.join(" | ")} |`)].join("\n");
};

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
