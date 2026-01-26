package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 요세푸스 문제
 * 난이도: 실버 4
 * 링크: https://www.acmicpc.net/problem/1158
 *
 * 문제 :
 *      - 1번부터 N번까지 N명의 사람이 원을 이루고 앉아 있다.
 *      - K번째 사람을 제거하고, 남은 사람들로 같은 과정을 반복한다.
 *      - 마지막까지 제거되는 순서를 출력한다.
 *
 * 입력 :
 *      - 첫째 줄: N(1 ≤ N ≤ 5,000)과 K(1 ≤ K ≤ N)
 *
 * 출력 :
 *      - <1, 2, 3, ...> 형태로 요세푸스 순열 출력
 *
 * 문제 풀이 :
 *      - 자료구조: 큐 또는 리스트 이용
 *      - K번째 사람 제거 후 리스트/큐 순환 반복
 */

public class BOJ_1158 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 1;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            queue.offer(i);

        sb.append("<");

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (count == K) {
                sb.append(num);
                count = 1;

                if (queue.size() != 0)
                    sb.append(", ");

                continue;
            }

            queue.offer(num);
            count++;
        }

        sb.append(">");

        System.out.println(sb);

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
