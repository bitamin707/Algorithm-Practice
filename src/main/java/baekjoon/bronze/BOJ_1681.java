package baekjoon.bronze;

import java.io.*;
import java.util.*;

/**
 * 제목: 줄 세우기
 * 난이도: 브론즈 1
 * 링크: https://www.acmicpc.net/problem/1681
 * <p>
 * 문제 :
 * - N명의 학생들에게 양의 정수로 된 라벨을 붙이려고 함.
 * - 모든 라벨은 서로 달라야 하며, 특정 숫자 L이 포함되어서는 안 됨.
 * - 조건을 만족하는 가장 작은 라벨부터 순서대로 붙일 때, N번째 학생의 라벨을 구하는 문제.
 * <p>
 * 입력 :
 * - 첫째 줄에 N(학생 수, 1 ≤ N ≤ 1,000,000)과 L(제외할 숫자, 0 ≤ L ≤ 9)이 공백으로 주어짐.
 * <p>
 * 출력 :
 * - N번째 학생에게 할당될 라벨의 최솟값을 출력.
 * <p>
 * 문제 풀이 :
 * - 1부터 시작하여 숫자를 1씩 증가시키며 검사함.
 * - 해당 숫자에 L이 포함되어 있는지 확인 (문자열 변환 또는 % 연산 활용).
 * - L이 포함되어 있지 않다면 카운트를 증가시키고, 카운트가 N에 도달하면 해당 숫자를 반환.
 */
public class BOJ_1681 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        String L = str[1];
        int num = 1;
        int count = 0;

        while (true) {
            String s = String.valueOf(num);
            if (!s.contains(L))
                count++;
            if (count == N)
                break;
            num++;
        }

        System.out.println(num);
        return String.valueOf(num);
    }

    public static void main(String[] args) {
        
    }
}