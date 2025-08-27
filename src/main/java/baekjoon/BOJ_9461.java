package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 파도반 수열
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/9461
 *
 * 문제 :
 *      - 삼각형이 나선 모양으로 놓여진 파도반 수열 P(N) 구하기
 *      - 첫 삼각형은 정삼각형으로 변의 길이는 1
 *      - 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가
 *      - P(1)부터 P(10)까지: 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
 *
 * 입력 :
 *      - 첫째 줄: 테스트 케이스의 개수 T
 *      - 각 테스트 케이스: N (1 ≤ N ≤ 100)
 *
 * 출력 :
 *      - 각 테스트 케이스마다 P(N) 출력
 *
 * 문제 풀이 :
 *      - 동적 계획법(DP) 문제
 *      - N ≥ 4일 때 점화식: P(N) = P(N-2) + P(N-3)
 *      - 초기값: P(1)=1, P(2)=1, P(3)=1
 *      - 값이 int 범위를 초과하므로 long 타입 사용 필요
 *      - 알고리즘: DP, 수학, 점화식
 */

public class BOJ_9461 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[] seq = setSequence();

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());

            sb.append(seq[num - 1]).append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }

    private static long[] setSequence() {
        long[] seq = new long[100];
        seq[0] = 1;
        seq[1] = 1;
        seq[2] = 1;
        seq[3] = 2;
        seq[4] = 2;

        for (int i = 5; i < seq.length; i++)
            seq[i] = seq[i - 2] + seq[i - 3];

        return seq;
    }

    public static void main(String[] args) {

    }
}