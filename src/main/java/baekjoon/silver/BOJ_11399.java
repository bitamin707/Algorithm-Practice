package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: ATM
 * 난이도: 실버 4
 * 링크: https://www.acmicpc.net/problem/11399
 *
 * 문제 : N명의 사람이 ATM에서 돈을 인출하려고 한다.
 *       각 사람이 돈을 인출하는 데 걸리는 시간이 다를 때,
 *       모든 사람이 돈을 인출하는 데 필요한 시간의 합의 최솟값을 구하는 문제.
 *
 * 입력 :
 *      - 첫째 줄에 사람 수 N (1 ≤ N ≤ 1,000)
 *      - 둘째 줄에 각 사람이 돈을 인출하는 데 걸리는 시간 P_i (1 ≤ P_i ≤ 1,000)가 주어진다.
 *
 * 출력 :
 *      - 각 사람이 돈을 인출하는 데 필요한 시간의 합의 최솟값을 출력한다.
 *
 * 문제 풀이 :
 *      - 각 사람의 인출 시간을 오름차순으로 정렬
 *      - 앞사람이 걸린 시간은 뒤사람에게 누적되므로,
 *        누적합을 계산하여 전체 합을 구하면 된다.
 */


public class BOJ_11399 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] times = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(times);

        int result = 0, elapsedTime = 0;
        for (int time : times) {
            elapsedTime += time;
            result += elapsedTime;
        }

        System.out.println(result);
        return String.valueOf(result);
    }

    public static void main(String[] args) {
    }
}
