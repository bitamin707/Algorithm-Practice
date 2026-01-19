package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 강의실 배정
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/11000
 * <p>
 * 문제 :
 * - 수강신청 기간이 끝나고, 모든 수업을 배정해야 한다.
 * - N개의 수업이 주어지며, 각 수업은 시작 시간 S와 종료 시간 T를 갖는다.
 * - 최소한의 강의실을 사용하여 모든 수업을 가능하게 하려 한다.
 * - 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (T_i <= S_j)
 * <p>
 * 입력 :
 * - 첫째 줄에 N (1 ≤ N ≤ 200,000)
 * - 둘째 줄부터 N개의 줄에 S_i, T_i가 주어진다. (0 ≤ S_i < T_i ≤ 10^9)
 * <p>
 * 출력 :
 * - 필요한 최소 강의실 개수를 출력한다.
 */
public class BOJ_11000 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            time[i][0] = start;
            time[i][1] = end;
        }

        Arrays.sort(time, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];

            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(time[0][1]);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= time[i][0]) {
                pq.poll();
                pq.offer(time[i][1]);
            } else {
                pq.offer(time[i][1]);
            }
        }

        System.out.println(pq.size());
        return String.valueOf(pq.size());
    }

    public static void main(String[] args) {
    }
}