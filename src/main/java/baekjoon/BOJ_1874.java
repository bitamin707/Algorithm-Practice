package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 스택 수열
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/1874
 *
 * 문제 : 1부터 N까지의 수를 스택에 넣었다가 뽑는 방식으로 특정 수열을 만들 수 있는지 판단하고,
 *       만들 수 있다면 어떤 Push(+), Pop(-) 연산이 필요한지를 출력하는 문제
 *
 * 입력 :
 *      - 첫째 줄에 수열의 길이 N (1 ≤ N ≤ 100,000)
 *      - 둘째 줄부터 N개의 줄에 수열의 각 원소 (1~N 중 하나씩 등장)
 *
 * 출력 :
 *      - 가능한 경우 연산을 한 줄씩 출력 (+, -)
 *      - 불가능한 경우 "NO"
 *
 * 문제 풀이 :
 *      - 1부터 N까지 하나씩 스택에 push(+)해 나가며
 *      - 현재 스택 top이 수열의 원하는 숫자와 같을 때만 pop(-)
 *      - 원하는 숫자보다 top이 크면 불가능 (NO)
 */

public class BOJ_1874 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int pointer = 1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            while (pointer <= num) {
                stack.push(pointer++);
                sb.append("+\n");
            }

            if (stack.peek() != num) {
                sb = new StringBuilder("NO");
                break;
            }

            stack.pop();
            sb.append("-\n");

        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        return sb.toString().trim();
    }

    public static void main(String[] args) {
    }
}
