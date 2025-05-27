package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 덱
 * 난이도: 실버 4
 * 링크: https://www.acmicpc.net/problem/10866
 * <p>
 * 문제 : 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 문제
 * 입력 :
 * - 첫 줄에 테스트 케이스의 수가 주어진다. N (1 <= N <= 10,000)
 * - 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
 * - 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
 * 출력 : 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 * <p>
 * 문제 풀이 :
 *      - 명령이 주어질 때마다, 커멘드와 정수를 분리
 *      - 명령에 따라 한 줄에 하나씩 출력
 *      - 명령은 총 여덟 가지이다.
 *        push_front X: 정수 X를 덱의 앞에 넣는다.
 *        push_back X: 정수 X를 덱의 뒤에 넣는다.
 *        pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *        pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *        size: 덱에 들어있는 정수의 개수를 출력한다.
 *        empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 *        front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *        back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

public class BOJ_10866 {
    public static String solve(String input) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;

            Command eCommand = Command.valueOf(command);

            switch (eCommand) {
                case push_front -> {
                    deque.addFirst(num);
                }
                case push_back -> {
                    deque.addLast(num);
                }
                case pop_front -> {
                    sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append('\n');
                }
                case pop_back -> {
                    sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append('\n');
                }
                case size -> {
                    sb.append(deque.size()).append('\n');
                }
                case empty -> {
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                }
                case front -> {
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
                }
                case back -> {
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
    }

    private enum Command {
        push_front, push_back, pop_front, pop_back, size, empty, front, back
    }
}
