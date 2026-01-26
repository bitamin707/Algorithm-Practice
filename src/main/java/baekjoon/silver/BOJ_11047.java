package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 동전 0
 * 난이도: 실버 4
 * 링크: https://www.acmicpc.net/problem/11047
 *
 * 문제 : 동전 N종류와 총합 K가 주어졌을 때, K원을 만들기 위해 필요한 동전 개수의 최솟값을 구하는 문제.
 *       각 동전은 배수 관계로 주어지며, 무한히 사용할 수 있다.
 *
 * 입력 :
 *      - 첫째 줄에 동전 종류 수 N (1 ≤ N ≤ 10)과 목표 금액 K (1 ≤ K ≤ 100,000,000)가 주어진다.
 *      - 다음 N개의 줄에는 각 동전의 가치 A_i (1 ≤ A_i ≤ 1,000,000)가 오름차순으로 주어진다.
 *
 * 출력 :
 *      - 목표 금액 K를 만들기 위해 필요한 동전의 개수의 최솟값을 출력한다.
 *
 * 문제 풀이 :
 *      - 가장 큰 가치의 동전부터 차례대로 사용하여 K에서 차감하는 그리디 알고리즘 적용
 *      - 각 동전은 K가 해당 동전 가치 이상일 때 최대한 많이 사용
 *      - 동전 가치를 내림차순으로 순회하면서 남은 금액을 갱신
 */


public class BOJ_11047 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int coinCount = 0;
        List<Integer> coinValue = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value > K)
                break;
            coinValue.add(value);
        }

        for (int i = coinValue.size() - 1; i >= 0; i--) {
            int count = K / coinValue.get(i);
            coinCount += count;
            K -= coinValue.get(i) * count;
        }

        System.out.print(coinCount);
        return String.valueOf(coinCount);
    }

    public static void main(String[] args) {
    }
}
