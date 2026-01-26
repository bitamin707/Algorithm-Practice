package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 패션왕 신해빈
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/9375
 *
 * 문제 :
 *      - 해빈이가 가진 의상들로 만들 수 있는 서로 다른 조합의 수 구하기
 *      - 같은 종류의 의상은 최대 1개만 착용 가능
 *      - 알몸 상태는 불가능 (적어도 하나의 의상은 착용해야 함)
 *      - 의상의 이름은 상관없고, 의상의 종류만 중요
 *
 * 입력 :
 *      - 첫째 줄: 테스트 케이스의 개수 (최대 100)
 *      - 각 테스트 케이스마다:
 *        - 의상의 수 n (0 ≤ n ≤ 30)
 *        - n개의 줄: 의상의 이름과 의상의 종류 (공백으로 구분)
 *
 * 출력 :
 *      - 각 테스트 케이스마다 서로 다른 의상의 조합의 수 출력
 *
 * 문제 풀이 :
 *      - 조합론 문제: 각 의상 종류별로 (착용 개수 + 1)을 곱하고 -1
 *      - +1은 해당 종류를 착용하지 않는 경우를 포함
 *      - -1은 모든 종류를 착용하지 않는 경우(알몸)를 제외
 *      - HashMap을 사용하여 의상 종류별 개수 카운트
 *      - 알고리즘: 수학, 조합론, HashMap
 */

public class BOJ_9375 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            int count = 1;

            for (int j = 0; j < num; j++) {
                String[] str = br.readLine().split(" ");
                map.put(str[1], map.getOrDefault(str[1], 0) + 1);
            }

            for (int n : map.values())
                count *= n + 1;

            sb.append(count - 1).append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}