package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: N과 M (9)
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/15663
 *
 * 문제 :
 *      - N개의 자연수가 주어질 때, 그 중에서 M개를 고른 수열을 모두 구하기
 *      - 같은 수를 여러 번 골라도 되지만, 수열 자체는 중복되면 안 됨
 *
 * 입력 :
 *      - 첫째 줄: N과 M (1 ≤ M ≤ N ≤ 8)
 *      - 둘째 줄: N개의 수 (10,000보다 작거나 같은 자연수)
 *
 * 출력 :
 *      - 조건을 만족하는 수열을 한 줄에 하나씩 출력
 *      - 중복되는 수열을 여러 번 출력하면 안됨
 *      - 수열은 사전 순으로 증가하는 순서로 출력
 *
 * 문제 풀이 :
 *      - 백트래킹으로 순열 생성
 *      - 입력 배열을 정렬하여 사전순 보장
 *      - 같은 깊이에서 이전에 사용한 수를 다시 사용하지 않도록 중복 체크
 *      - visited 배열로 같은 수를 중복 사용하지 않도록 관리
 */

public class BOJ_15663 {
    static StringBuilder sb;
    static int N, M;
    static int[] numbers, arr;
    static boolean[] visit;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        arr = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);

        dfs(0);

        System.out.println(sb);
        return sb.toString();
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int n : arr)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }

        int num = -1;
        for (int i = 0; i < N; i++) {
            int now = numbers[i];

            if (visit[i] || num == now)
                continue;

            visit[i] = true;
            num = now;
            arr[depth] = now;
            dfs(depth + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
    }
}
