package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 절댓값 힙
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/11286
 *
 * 문제 :
 *      - 절댓값이 가장 작은 값을 출력하고 제거하는 자료구조 구현
 *      - 절댓값이 같다면 더 작은 수를 우선 출력
 *      - x가 0이 아니면 배열에 x 추가, x가 0이면 절댓값이 가장 작은 값 출력 후 제거
 *
 * 입력 :
 *      - 첫째 줄: 연산의 개수 N (1 ≤ N ≤ 100,000)
 *      - 다음 N개 줄: 정수 x (-2^31 < x < 2^31, x ≠ 0이면 배열에 추가, x = 0이면 출력)
 *
 * 출력 :
 *      - x = 0일 때마다 절댓값이 가장 작은 값을 출력
 *      - 배열이 비어있는데 0이 주어지면 0 출력
 *
 * 문제 풀이 :
 *      - PriorityQueue 사용하여 우선순위 힙 구현
 *      - Comparator를 통해 절댓값 기준 정렬, 절댓값이 같으면 실제 값으로 정렬
 *      - 알고리즘: 우선순위 큐(힙), 자료구조
 */

public class BOJ_11286 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2))
                    return o1 - o2;
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (queue.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(queue.poll()).append("\n");
            } else
                queue.offer(x);
        }

        System.out.println(sb);
        return sb.toString();
    }
}
