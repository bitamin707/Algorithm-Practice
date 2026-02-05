package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 박스 쌓기
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/34927
 * <p>
 * 문제 :
 * - N개의 박스가 있고, i번째 박스의 무게는 w_i임.
 * - 박스를 쌓을 때, 특정 박스 위에 있는 모든 박스 무게의 합이 해당 박스의 무게 이하여야 함.
 * - 최대한 많은 박스를 쌓았을 때의 개수를 구하는 문제.
 * <p>
 * 입력 :
 * - 첫째 줄에 박스의 개수 N (2 ≤ N ≤ 300,000)
 * - 둘째 줄에 박스의 무게 w_1, ..., w_N (1 ≤ w_i ≤ 10^9)
 * <p>
 * 출력 :
 * - 쌓을 수 있는 박스의 최대 개수
 * <p>
 * 문제 풀이 :
 * - 위에 놓인 박스들의 무게 합이 작을수록 아래에 더 많은 박스를 받칠 수 있음.
 * - 박스 무게를 오름차순으로 정렬함.
 * - 가장 가벼운 박스부터 하나씩 쌓으면서, 현재까지 쌓인 박스들의 무게 합(sum)이
 * 새로 밑에 놓일 박스의 무게(w_i) 이하인지 확인하며 카운트함.
 */

public class BOJ_34927 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int count = 1;
        int sum = arr[0];

        for (int i = 1; i < N; i++) {
            if (sum <= arr[i]) {
                count++;
                sum += arr[i];
            }
        }

        System.out.println(count);
        return String.valueOf(count);
    }

    public static void main(String[] args) {

    }
}
