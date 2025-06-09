package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: ISBN
 * 난이도: 브론즈 1
 * 링크: https://www.acmicpc.net/problem/14626
 *
 * 문제 : 숫자 13개로 구성된 ISBN 문자열이 주어진다. 이 중 한 자리에만 'X'가 들어 있으며,
 *       'X'가 들어간 자리에 0~9 숫자 중 하나를 대입하여 유효한 ISBN을 만들 수 있는 숫자를 구하는 문제
 *       (검증은 ISBN 검증 공식 사용)
 *
 * 입력 :
 *      - 첫째 줄에 길이 13의 문자열이 주어진다. 숫자 또는 'X'로 구성됨 (X는 단 한 번만 등장)
 *
 * 출력 :
 *      - 대입 가능한 숫자 0~9 중 유효한 ISBN이 되는 숫자를 출력한다.
 *      - 유효한 숫자가 없다면 -1을 출력한다.
 *
 * 문제 풀이 :
 *      - 입력 문자열에서 '*' 위치를 찾는다.
 *      - '*'를 제외한 각 자리 숫자를 배열에 저장한다.
 *      - ISBN 검증 공식에 따라 가중치를 적용해 합산한다.
 *        - 짝수 인덱스 숫자는 그대로 더하고, 홀수 인덱스 숫자는 3배하여 더한다.
 *      - '*' 위치에 0~9 숫자를 대입해 전체 합이 10으로 나누어 떨어지는지 확인한다.
 *      - 조건에 맞는 첫 숫자를 반환하며, 없으면 -1 반환.
 */

public class BOJ_14626 {
    public static int solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        String value = br.readLine();
        int findStart = value.indexOf('*');
        int[] numArr = new int[value.length()];

        for (int i = 0; i < input.length(); i++) {
            if (i == findStart) {
                continue;
            }
            numArr[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        System.out.println();
        int m = 0;
        for (int i = 0; i < numArr.length; i++) {
            if (i == findStart) {
                continue;
            }
            if ((i % 2) == 0) {
                m += numArr[i];
            }
            else {
                m += (3 * numArr[i]);
            }
        }

        for (int i = 0; i < 10; i++) {
            int trialSum;
            if (findStart % 2 == 0) {
                trialSum = m + i;
            } else {
                trialSum = m + i * 3;
            }

            if (trialSum % 10 == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
