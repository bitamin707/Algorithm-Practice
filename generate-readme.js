const fs = require("fs");
const path = require("path");

const bojDir = "src/main/java/baekjoon";
const pgDir = "src/main/java/programmers";
const testBojDir = "src/test/java/baekjoon";
const testPgDir = "src/test/java/programmers";

function extractMeta(filePath) {
    const content = fs.readFileSync(filePath, "utf8");
    const titleMatch = content.match(/\*\s*제목:\s*(.+)/);
    const levelMatch = content.match(/\*\s*난이도:\s*(.+)/);
    const linkMatch = content.match(/\*\s*링크:\s*(.+)/);

    return {
        title: titleMatch?.[1]?.trim() || "제목 미정",
        level: levelMatch?.[1]?.trim() || "난이도 미정",
        link: linkMatch?.[1]?.trim() || "#",
    };
}

function getEntries(dir, testDir, prefix) {
    const entries = [];

    fs.readdirSync(dir)
        .filter((file) => file.endsWith(".java"))
        .forEach((file) => {
            const filePath = path.join(dir, file);
            const { title, level, link } = extractMeta(filePath);

            const fileNameNoExt = path.parse(file).name;
            const testFileName = fileNameNoExt.replace("_", "") + "Test.java";
            const testFilePath = path.join(testDir, testFileName);

            const codeLink = `[코드](./${filePath})`;
            const testLink = fs.existsSync(testFilePath)
                ? `[테스트](./${testFilePath})`
                : "❌";
            const urlLink = `[문제 링크](${link})`;

            const id = prefix === "BOJ" ? fileNameNoExt.split("_")[1] : "";
            entries.push({
                level,
                id,
                title,
                codeLink,
                testLink,
                urlLink,
                prefix,
            });
        });

    return entries.sort((a, b) =>
        a.prefix === "BOJ"
            ? parseInt(a.id) - parseInt(b.id)
            : a.title.localeCompare(b.title)
    );
}

function generateReadme(bojEntries, pgEntries) {
    const bojTable =
        `### ✅ 백준 (Baekjoon)\n\n| 난이도 | 문제 번호 | 제목 | 코드 | 테스트 | 링크 |\n|--------|-----------|------|------|--------|---|\n` +
        bojEntries
            .map(
                (e) =>
                    `| ${e.level} | ${e.id} | ${e.title} | ${e.codeLink} | ${e.testLink} | ${e.urlLink} |`
            )
            .join("\n");

    const pgTable =
        `\n\n### ✅ 프로그래머스 (Programmers)\n\n| 난이도 | 제목 | 코드 | 테스트 | 링크 |\n|--------|------|------|--------|---|\n` +
        pgEntries
            .map(
                (e) =>
                    `| ${e.level} | ${e.title} | ${e.codeLink} | ${e.testLink} | ${e.urlLink} |`
            )
            .join("\n");

    const header = `# 알고리즘 문제 풀이 저장소 (Java + JUnit)
📘 백준(BOJ), 프로그래머스(Programmers) 등에서 푼 알고리즘 문제를 기록합니다.  

📌 Java 기반, 테스트는 JUnit 사용  

📂 문제별 디렉토리 구조 유지 + 문제 설명 및 풀이 전략 포함


## 🔥 문제 풀이 목록
`;

    fs.writeFileSync("README.md", header + "\n" + bojTable + pgTable);
    console.log("✅ README.md 갱신 완료");
}

const bojEntries = getEntries(bojDir, testBojDir, "BOJ");
const pgEntries = getEntries(pgDir, testPgDir, "PG");

generateReadme(bojEntries, pgEntries);
