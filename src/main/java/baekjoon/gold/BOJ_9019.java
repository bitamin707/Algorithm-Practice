package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 제목: DSLR
 * 난이도: 골드 4
 * 링크: https://www.acmicpc.net/problem/9019
 *
 * 문제 :
 *      - 네 개의 명령어 D, S, L, R을 이용하는 간단한 계산기가 있다
 *      - 0 이상 10,000 미만의 십진수 A를 B로 변환하기 위해 필요한 최소한의 명령어 나열을 출력
 *      - D: n을 두 배로 바꾼다 (2n mod 10000)
 *      - S: n에서 1을 뺀다 (n이 0이면 9999)
 *      - L: 각 자릿수를 왼편으로 회전 (1234 → 2341)
 *      - R: 각 자릿수를 오른편으로 회전 (1234 → 4123)
 *
 * 입력 :
 *      - 첫째 줄: 테스트 케이스의 개수 T (1 ≤ T ≤ 100)
 *      - 다음 T개 줄: 각 줄에 정수 A와 B (0 ≤ A, B < 10000)
 *
 * 출력 :
 *      - 각 테스트 케이스마다 A를 B로 변환하기 위해 필요한 최소한의 명령어 나열
 *
 * 문제 풀이 :
 *      - BFS를 이용하여 최단 경로(최소 명령어)를 찾는다
 *      - 각 숫자에서 D, S, L, R 연산을 수행하여 새로운 숫자를 생성
 *      - 방문 체크를 통해 중복 방문을 방지
 *      - 목표 숫자에 도달하면 경로를 역추적하여 명령어 나열을 출력
 */

public class BOJ_9019 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            sb.append(bfs(start, target)).append("\n");
        }
        System.out.println(sb);
        return sb.toString();
    }

    private static String bfs(int start, int target) {
        if (start == target)
            return "";

        boolean[] visit = new boolean[10000];
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State(start, ""));
        visit[start] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (cur.number == target)
                return cur.path;

            int next = commandD(cur.number);
            if (!visit[next]) {
                queue.offer(new State(next, cur.path + "D"));
                visit[next] = true;
            }

            next = commandS(cur.number);
            if (!visit[next]) {
                queue.offer(new State(next, cur.path + "S"));
                visit[next] = true;
            }

            next = commandL(cur.number);
            if (!visit[next]) {
                queue.offer(new State(next, cur.path + "L"));
                visit[next] = true;
            }

            next = commandR(cur.number);
            if (!visit[next]) {
                queue.offer(new State(next, cur.path + "R"));
                visit[next] = true;
            }
        }
        return "";
    }

    private static int commandD(int num) {
        int result = num * 2;
        if (result > 9999)
            return result % 10000;
        return result;
    }

    private static int commandS(int num) {
        if (num == 0)
            return 9999;
        return num - 1;
    }

    private static int commandL(int num) {
        int first = num / 1000;
        num %= 1000;
        num *= 10;
        return num + first;
    }

    private static int commandR(int num) {
        int last = num % 10;
        num /= 10;
        return num + (last * 1000);
    }

    private static class State {
        int number;
        String path;

        State(int number, String path) {
            this.number = number;
            this.path = path;
        }
    }

    public static void main(String[] args) {
    }
}
