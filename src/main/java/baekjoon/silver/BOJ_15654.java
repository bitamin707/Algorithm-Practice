package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: N과 M (5)
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/15654
 *
 * 문제 :
 *      - N개의 자연수와 자연수 M이 주어졌을 때, 조건을 만족하는 길이가 M인 수열을 모두 구하기
 *      - N개의 자연수는 모두 다른 수이다
 *      - N개의 자연수 중에서 M개를 고른 수열
 *      - 중복 없이 M개를 골라야 함 (순열)
 *
 * 입력 :
 *      - 첫째 줄: N과 M (1 ≤ M ≤ N ≤ 8)
 *      - 둘째 줄: N개의 수 (10,000보다 작거나 같은 자연수)
 *
 * 출력 :
 *      - 한 줄에 하나씩 조건을 만족하는 수열을 출력
 *      - 중복되는 수열을 여러 번 출력하면 안됨
 *      - 각 수열은 공백으로 구분해서 출력
 *      - 수열은 사전 순으로 증가하는 순서로 출력
 *
 * 문제 풀이 :
 *      - 백트래킹(DFS)을 이용한 순열(Permutation) 구현
 *      - 15649번과의 차이점: 1~N이 아닌 주어진 N개의 수 사용
 *      - 핵심: 입력받은 배열을 정렬한 후 순열 생성 (사전순 보장)
 *      - 방문 배열로 중복 선택 방지
 *      - 각 위치에서 모든 수를 시도 가능 (순서 중요)
 */

public class BOJ_15654 {
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

        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (visit[i] || numbers[i] == prev) continue;

            visit[i] = true;
            arr[depth] = numbers[i];
            prev = numbers[i];
            dfs(depth + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
    }
}
