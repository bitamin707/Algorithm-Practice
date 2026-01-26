package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 잃어버린 괄호
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/1541
 *
 * 문제 :
 *      - 양수와 +, -, 괄호로 만든 식에서 괄호를 모두 지운 후
 *      - 괄호를 적절히 쳐서 식의 값을 최소로 만드는 프로그램
 *      - 최소값을 만들기 위해서는 가능한 많은 양수를 빼야 함
 *
 * 입력 :
 *      - 첫째 줄: 식 (길이 ≤ 50)
 *      - 식은 '0'~'9', '+', '-'로만 구성
 *      - 처음과 마지막 문자는 숫자
 *      - 연속된 연산자 없음, 5자리 초과 숫자 없음
 *      - 수는 0으로 시작 가능
 *
 * 출력 :
 *      - 괄호를 적절히 쳐서 만들 수 있는 식의 최소값
 *
 * 문제 풀이 :
 *      - 그리디 알고리즘 문제
 *      - 핵심 아이디어: 처음 '-' 이후 모든 수들을 괄호로 묶어서 빼기
 *      - 예: 55-50+40 → 55-(50+40) = -35
 *      - 예: 5-4+6-2 → 5-(4+6)-(2) = -7
 *      - 구현: '-'로 split 후 첫 부분은 더하고 나머지는 빼기
 *      - 알고리즘: 그리디, 문자열 처리
 */

public class BOJ_1541 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        Integer result = null;
        while (st.hasMoreTokens()){
            int num = 0;
            StringTokenizer s = new StringTokenizer(st.nextToken(), "+");

            while (s.hasMoreTokens())
                num += Integer.parseInt(s.nextToken());

            if (result == null)
                result = num;
            else
                result -= num;
        }

        System.out.println(result);
        return String.valueOf(result);
    }

    public static void main(String[] args) {
    }
}