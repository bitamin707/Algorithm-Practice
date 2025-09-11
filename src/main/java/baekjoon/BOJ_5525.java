package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: IOIOI
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/5525
 *
 * 문제 :
 *      - N+1개의 I와 N개의 O로 이루어진 문자열을 PN이라고 함
 *      - P1 = IOI, P2 = IOIOI, P3 = IOIOIOI, ...
 *      - PN = IOIOI...OI (O가 N개)
 *      - I와 O로만 이루어진 문자열 S에서 PN이 몇 군데 포함되어 있는지 구하기
 *
 * 입력 :
 *      - 첫째 줄: N (1 ≤ N ≤ 1,000,000)
 *      - 둘째 줄: S의 길이 M (2N+1 ≤ M ≤ 1,000,000)
 *      - 셋째 줄: 문자열 S (I와 O로만 구성)
 *
 * 출력 :
 *      - S에서 PN이 몇 군데 포함되어 있는지 출력
 *
 * 문제 풀이 :
 *      - 방법 1: 단순 문자열 매칭 (50점) - O(MN) 시간복잡도
 *      - 방법 2: IOI 패턴 카운팅 (100점) - O(M) 시간복잡도
 *      - IOI 패턴이 N번 연속으로 나오면 PN 완성
 *      - 겹치는 부분 고려 필요 (예: IOIOIOI에서 P1이 2개)
 *      - 최적화: IOI를 찾으면 인덱스를 2씩 증가시켜 효율적으로 탐색
 */

public class BOJ_5525 {

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        int ioi_count = 0;
        for (int i = 0; i < M - 2; i++) {
            if (S.charAt(i) == 'I' && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                ioi_count++;

                if (ioi_count >= N)
                    count++;

                i++;
            } else
                ioi_count = 0;
        }

        System.out.println(count);
        return String.valueOf(count);
    }

    public static void main(String[] args) {
    }
}
