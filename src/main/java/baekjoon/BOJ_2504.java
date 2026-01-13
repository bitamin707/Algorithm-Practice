package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 괄호의 값
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/2504
 * <p>
 * 문제 :
 * - 4개의 기호 ‘(’, ‘)’, ‘[’, ‘]’를 이용해서 만들어진 올바른 괄호열에 대해 그 값을 계산한다.
 * - ‘()’는 2, ‘[]’는 3이다.
 * - ‘(x)’의 값은 2 * (x의 값)이다.
 * - ‘[x]’의 값은 3 * (x의 값)이다.
 * - 올바른 괄호열 x와 y가 결합된 xy의 값은 (x의 값) + (y의 값)이다.
 * - 만약 올바르지 못한 괄호열이면 0을 출력한다.
 * <p>
 * 입력 :
 * - 첫째 줄에 괄호열을 나타내는 문자열이 주어진다. (길이 1 ~ 30)
 * <p>
 * 출력 :
 * - 계산된 괄호의 값을 출력한다. 올바르지 않다면 0을 출력.
 */

public class BOJ_2504 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int tmp = 1;

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            if (cur == '(') {
                stack.push(cur);
                tmp *= 2;
            } else if (cur == '[') {
                stack.push(cur);
                tmp *= 3;
            } else if (cur == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                if (str.charAt(i - 1) == '(')
                    result += tmp;
                stack.pop();
                tmp /= 2;
            } else if (cur == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (str.charAt(i - 1) == '[')
                    result += tmp;
                stack.pop();
                tmp /= 3;
            }
        }

        if (!stack.isEmpty())
            return "0";

        return String.valueOf(result);
    }
}
