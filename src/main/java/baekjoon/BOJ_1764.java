package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 듣보잡
 * 난이도: 실버 4
 * 링크: https://www.acmicpc.net/problem/1764
 *
 * 문제 : 듣도 못한 사람 N명과 보도 못한 사람 M명의 명단이 주어진다.
 *       이 중에서 듣도 보도 못한 사람의 명단을 사전 순으로 출력하는 문제
 *
 * 입력 :
 *      - 첫째 줄에 N과 M이 주어진다. (1 ≤ N, M ≤ 500,000)
 *      - 둘째 줄부터 N개의 줄에는 듣도 못한 사람의 이름
 *      - 그 다음 M개의 줄에는 보도 못한 사람의 이름이 주어진다.
 *      - 이름은 중복되지 않으며 길이는 20자 이하, 알파벳 소문자
 *
 * 출력 :
 *      - 듣보잡의 수를 출력한 후, 듣보잡의 명단을 사전 순으로 한 줄에 하나씩 출력
 *
 * 문제 풀이 :
 *      - HashSet으로 N 리스트의 사람을 등록
 *      - M 리스트 등록 시 N 리스트에 있는 사람을 비교하며 존재하면 추가
 *      - 사전순으로 정렬 후 출력
 */


public class BOJ_1764 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] testCase = br.readLine().split(" ");
        int N = Integer.parseInt(testCase[0]);
        int M = Integer.parseInt(testCase[1]);
        Set<String> NList = new HashSet<>();
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < N; i++)
            NList.add(br.readLine());
        for (int i = 0; i < M; i++) {
            String man = br.readLine();
            if (NList.contains(man)) {
                newList.add(man);
            }
        }
        Collections.sort(newList);
        sb.append(newList.size()).append("\n");
        for (String man : newList)
            sb.append(man).append("\n");

        // bw.write(sb.toString());
        // bw.flush();
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
