package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: N과 M (12)
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/15666
 *
 * 문제 :
 *      - N개의 자연수가 주어질 때, 그 중에서 M개를 고른 수열을 모두 구하기
 *      - 같은 수를 여러 번 골라도 됨
 *      - 수열은 비내림차순이어야 함
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
 *      - 백트래킹으로 중복 조합 생성
 *      - 입력 배열에서 중복 제거 후 정렬 (사전순 보장 + 중복 수열 방지)
 *      - 비내림차순: 이전에 선택한 인덱스 이상부터 선택 가능
 *      - 같은 수를 여러 번 선택 가능 (중복 조합)
 */

public class BOJ_15666 {
    static StringBuilder sb;
    static int N, M;
    static TreeSet<Integer> set;
    static int[] arr;
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new TreeSet<>();
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            set.add(Integer.parseInt(st.nextToken()));

        dfs(0, -1);

        System.out.println(sb);
        return sb.toString();
    }

    private static void dfs(int depth, int startNum) {
        if (depth == M) {
            for(int n : arr)
                sb.append(n).append(" ");
            sb.append("\n");
            return;
        }
        for (int n : set) {
            if (n < startNum)
                continue;

            arr[depth] = n;
            dfs(depth + 1, n);
        }
    }

    public static void main(String[] args) {
    }
}
