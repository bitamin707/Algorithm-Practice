package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 비밀번호 찾기
 * 난이도: 실버 4
 * 링크: https://www.acmicpc.net/problem/17219
 *
 * 문제 : 사이트 주소와 해당 비밀번호가 주어졌을 때,
 *       특정 사이트 주소에 해당하는 비밀번호를 빠르게 찾아 출력하는 문제.
 *
 * 입력 :
 *      - 첫째 줄에 저장된 사이트 주소 수 N (1 ≤ N ≤ 100,000)과
 *        비밀번호를 찾으려는 사이트 주소 수 M (1 ≤ M ≤ 100,000)가 주어진다.
 *      - 다음 N개의 줄에 "사이트 주소"와 "비밀번호"가 주어진다.
 *      - 다음 M개의 줄에 비밀번호를 찾으려는 사이트 주소가 주어진다.
 *      - 사이트 주소와 비밀번호는 알파벳 대소문자, 숫자로만 구성되며,
 *        길이는 최대 20자이다.
 *
 * 출력 :
 *      - 입력된 M개의 사이트 주소 순서대로 해당 비밀번호를 출력한다.
 *
 * 문제 풀이 :
 *      - 사이트 주소와 비밀번호를 해시맵(Map)에 저장하여 조회
 *      - N개의 입력을 모두 저장한 뒤, M개의 쿼리를 순서대로 처리
 */

public class BOJ_17219 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();

        String[] testCase = br.readLine().split(" ");
        int saveSiteCount = Integer.parseInt(testCase[0]);
        int findSiteCount = Integer.parseInt(testCase[1]);

        for (int i = 0; i < saveSiteCount; i++) {
            String[] site = br.readLine().split(" ");
            map.put(site[0], site[1]);
        }

        for (int i = 0; i < findSiteCount; i++) {
            String findSite = br.readLine();
            sb.append(map.get(findSite)).append("\n");
            bw.newLine();
        }
        bw.write(sb.toString());
        bw.flush();
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
