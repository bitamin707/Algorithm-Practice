package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 제목: 조별과제를 하려는데 조장이 사라졌다
 * 난이도: 브론즈 5
 * 링크: https://www.acmicpc.net/problem/15727
 * <p>
 * 문제 :
 * - 민우는 사라진 성우를 찾기 위해 성우의 집까지 이동해야 함.
 * - 민우는 1분에 1에서 5까지의 거리를 이동할 수 있음.
 * - 성우의 집까지의 거리 L이 주어졌을 때, 최소 몇 분 만에 도착할 수 있는지 구하는 문제.
 * <p>
 * 입력 :
 * - 성우의 집까지의 거리 L (1 ≤ L ≤ 1,000,000)
 * <p>
 * 출력 :
 * - 성우의 집까지 가는 데 걸리는 최소 시간
 * <p>
 * 문제 풀이 :
 * - 최소 시간을 구해야 하므로 매 분 가장 먼 거리인 5씩 이동함.
 * - 거리 L을 5로 나눈 몫을 기준으로, 나머지가 있으면 1분을 추가함.
 */
public class BOJ_15727 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int result = num / 5;
        result = num % 5 == 0 ? result : result + 1;
        System.out.println(result);

        return String.valueOf(result);
    }
}