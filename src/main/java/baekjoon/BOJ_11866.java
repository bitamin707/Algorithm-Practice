package baekjoon;

import java.io.*;
import java.util.*;

/**
 * [BOJ 11866] 요세푸스 문제 0
 * https://www.acmicpc.net/problem/11866
 *
 * ▪ 문제 유형: 큐, 자료 구조
 * ▪ 문제 개요:
 *   - N명의 사람이 원을 이루며 앉아 있고, K번째 사람을 제거하는 과정을 반복한다.
 *   - 제거된 순서를 출력한다.
 *
 */

public class BOJ_11866 {
    public static String solve(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        while(!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            result.add(queue.poll());
        }

        return formatString(result);
    }

    private static String formatString(List<Integer> result) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if(i != result.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(solve(n, k));
    }
}
