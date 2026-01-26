package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 숫자 카드 2
 * 난이도: 실버 4
 * 링크: https://www.acmicpc.net/problem/10816
 *
 * 문제 : 숫자 카드 N개를 가지고 있을 때, 정수 M개에 대해 이 숫자 카드에 포함되어 있는지를 구하는 문제
 * 입력 :
 *      - 첫째 줄에 숫자 카드의 개수 N (1 ≤ N ≤ 500,000)
 *      - 둘째 줄에 숫자 카드에 적혀있는 정수 N개
 *      - 셋째 줄에 찾고자 하는 숫자의 개수 M (1 ≤ M ≤ 500,000)
 *      - 넷째 줄에 M개의 정수
 * 출력 : 출력해야하는 명령이 주어질 때마다 한 줄에 하나씩 출력한다.
 *
 * 문제 풀이 :
 *      - N 개의 숫자를 입력 받아 HashMap을 통해 각 숫자의 개수를 저장
 *      - M개의 숫자를 입력 받아 각 숫자가 N개의 숫자에 몇 번 등작했는지 HashMap에서 조회
 *      - getOrDefault을 통해 존재하지 않는 숫자는 0으로 처리
 */

public class BOJ_10816 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int N = Integer.parseInt(br.readLine());
        int[] arrN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = Integer.parseInt(br.readLine());
        int[] arrM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int num : arrN) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arrM) {
            sb.append(map.getOrDefault(num, 0)).append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args){
    }
}
