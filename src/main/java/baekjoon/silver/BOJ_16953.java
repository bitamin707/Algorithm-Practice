package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: A → B
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/16953
 *
 * 문제 :
 *      - 정수 A를 B로 바꾸기
 *      - 가능한 연산: 1) 2를 곱한다, 2) 1을 수의 가장 오른쪽에 추가한다
 *      - A를 B로 바꾸는데 필요한 연산의 최솟값 구하기
 *
 * 입력 :
 *      - 첫째 줄: A, B (1 ≤ A < B ≤ 10^9)
 *
 * 출력 :
 *      - A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값 출력
 *      - 만들 수 없는 경우에는 -1을 출력
 *
 * 문제 풀이 :
 *      - BFS를 사용하여 최단 경로 탐색
 *      - long 타입 사용 필수 (중간 계산 과정에서 int 범위 초과 가능)
 *      - 연산 횟수 + 1을 출력해야 함에 유의
 */

public class BOJ_16953 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int result = bfs(A, B);
        System.out.println(result);
        return String.valueOf(result);
    }

    private static int bfs(long a, long b) {
        Queue<Long> queue = new ArrayDeque<>();
        Map<Long, Integer> visit = new HashMap<>();
        queue.offer(a);
        visit.put(a, 1);

        while (!queue.isEmpty()) {
            long curNum = queue.poll();
            int count = visit.get(curNum);

            long next1 = curNum * 2;
            long next2 = curNum * 10 + 1;

            if (next1 == b || next2 == b)
                return count + 1;

            if (next1 < b && !visit.containsKey(next1)) {
                queue.offer(next1);
                visit.put(next1, count + 1);
            }
            if (next2 < b && !visit.containsKey(next2)) {
                queue.offer(next2);
                visit.put(next2, count + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
