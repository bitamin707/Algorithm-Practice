package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 카드2
 * 난이도: 실버 4
 * 링크: https://www.acmicpc.net/problem/2164
 */

public class BOJ_2164 {

    public static int solve(int n) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        return queue.peek();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solve(n));
    }
}
