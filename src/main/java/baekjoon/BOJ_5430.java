package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: AC
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/5430
 *
 * 문제 :
 *      - 새로운 언어 AC는 정수 배열에 연산을 하는 언어
 *      - 두 가지 함수: R(뒤집기), D(버리기)
 *      - R: 배열에 있는 수의 순서를 뒤집는 함수
 *      - D: 첫 번째 수를 버리는 함수 (배열이 비어있으면 에러)
 *      - 함수는 조합해서 한 번에 사용 가능 (예: "RDD")
 *
 * 입력 :
 *      - 첫째 줄: 테스트 케이스의 개수 T (T ≤ 100)
 *      - 각 테스트 케이스마다:
 *        - 첫째 줄: 수행할 함수 p (길이 ≤ 100,000)
 *        - 둘째 줄: 배열에 들어있는 수의 개수 n (0 ≤ n ≤ 100,000)
 *        - 셋째 줄: 배열 형태 "[x1,x2,...,xn]" (0 ≤ xi ≤ 100)
 *
 * 출력 :
 *      - 각 테스트 케이스에 대해 함수를 수행한 결과 출력
 *      - 에러가 발생한 경우 "error" 출력
 *
 * 문제 풀이 :
 *      - Deque를 사용하여 양쪽 끝에서 삽입/삭제 효율적으로 처리
 *      - R 함수: 실제로 뒤집지 말고 방향 플래그로 관리 (시간 최적화)
 *      - D 함수: 방향에 따라 앞/뒤에서 제거
 *      - 배열 파싱: "[1,2,3]" 형태를 정수 배열로 변환
 */

public class BOJ_5430 {
    static StringBuilder sb;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            int num = Integer.parseInt(br.readLine());
            Deque<Integer> deque = setDeque(br.readLine());

            runCommand(cmd, deque);
        }

        System.out.println(sb);
        return sb.toString();
    }

    private static void runCommand(String cmd, Deque<Integer> deque) {
        boolean reverseFlag = false;
        for (int i = 0; i < cmd.length(); i++) {
            char c = cmd.charAt(i);

            if (c == 'R')
                reverseFlag = !reverseFlag;
            else if (c == 'D') {
                if (deque.isEmpty()) {
                    sb.append("error").append("\n");
                    return;
                } else if (reverseFlag)
                    deque.pollLast();
                else
                    deque.poll();
            }
        }

        sb.append("[");
        while (!deque.isEmpty()) {
            if (reverseFlag)
                sb.append(deque.pollLast());
            else
                sb.append(deque.poll());
            if (deque.size() > 0)
                sb.append(",");
        }
        sb.append("]").append("\n");
    }

    private static Deque<Integer> setDeque(String str) {
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(str.substring(1, str.length() - 1), ",");

        while (st.hasMoreTokens())
            deque.add(Integer.parseInt(st.nextToken()));

        return deque;
    }

    public static void main(String[] args) {
    }
}
