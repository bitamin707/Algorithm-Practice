package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 에디터
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/1406
 *
 * 문제 : 간단한 텍스트 에디터를 구현하는 문제.
 *       문자열과 커서가 주어진다. 커서는 문자의 사이(맨 앞, 맨 뒤 포함)에 위치할 수 있다.
 *       입력으로 주어진 명령어를 수행한 뒤 최종 문자열을 출력해야 한다.
 *
 * 명령어 종류 :
 *      - L : 커서를 왼쪽으로 한 칸 옮김 (맨 앞이면 무시)
 *      - D : 커서를 오른쪽으로 한 칸 옮김 (맨 뒤면 무시)
 *      - B : 커서 왼쪽의 문자를 삭제 (맨 앞이면 무시)
 *      - P x : 커서 왼쪽에 문자 x를 추가
 *
 * 입력 :
 *      - 첫째 줄: 초기 문자열 (길이 ≤ 100,000)
 *      - 둘째 줄: 명령어 개수 M (1 ≤ M ≤ 500,000)
 *      - 셋째 줄부터 M개의 줄: 명령어
 *
 * 출력 :
 *      - 모든 명령어를 수행한 후 최종 문자열을 출력한다.
 *
 * 문제 풀이 :
 *      - 커서를 기준으로 왼쪽/오른쪽을 관리할 수 있는 자료구조 사용
 *      - Stack 2개로 구현 가능
 */

public class BOJ_1406 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String inputStr = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (int i = 0; i < inputStr.length(); i++)
            leftStack.push(inputStr.charAt(i));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "L" :
                    if (!leftStack.isEmpty())
                        rightStack.push(leftStack.pop());
                    break;

                case "D" :
                    if (!rightStack.isEmpty())
                        leftStack.push(rightStack.pop());
                    break;

                case "B":
                    if(!leftStack.isEmpty())
                        leftStack.pop();
                    break;

                case "P":
                    leftStack.push(command[1].charAt(0));
                    break;
            }
        }

        for (char c : leftStack)
            sb.append(c);

        while (!rightStack.isEmpty())
            sb.append(rightStack.pop());

        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
