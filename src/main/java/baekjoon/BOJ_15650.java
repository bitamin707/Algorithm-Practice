package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: N과 M (2)
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/15650
 *
 * 문제 :
 *      - 자연수 N과 M이 주어졌을 때, 조건을 만족하는 길이가 M인 수열을 모두 구하기
 *      - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 *      - 고른 수열은 오름차순이어야 한다
 *
 * 입력 :
 *      - 첫째 줄: 자연수 N과 M (1 ≤ M ≤ N ≤ 8)
 *
 * 출력 :
 *      - 한 줄에 하나씩 조건을 만족하는 수열을 출력
 *      - 중복되는 수열을 여러 번 출력하면 안됨
 *      - 각 수열은 공백으로 구분해서 출력
 *      - 수열은 사전 순으로 증가하는 순서로 출력
 *
 * 문제 풀이 :
 *      - 백트래킹(DFS)을 이용한 조합(Combination) 구현
 *      - 15649번과 달리 오름차순 조건이 있음 -> 시작점(start) 관리 필요
 *      - 현재 선택한 숫자보다 큰 숫자만 다음에 선택 가능
 *      - 방문 체크 + 경로 추적하여 M개 선택 시 출력
 */

public class BOJ_15650 {
    static StringBuilder sb;
    static int N, M;
    static int[] numbers;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];

        dfs(0, 1);

        System.out.println(sb);
        return sb.toString();
    }

    private static void dfs(int depth, int index) {
        if (depth == M) {
            for (int n : numbers)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = index; i <= N; i++) {
            numbers[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) {
    }
}
