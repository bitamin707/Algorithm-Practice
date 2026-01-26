package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 집합
 * 난이도: 실버 5
 * 링크: https://www.acmicpc.net/problem/11723
 *
 * 문제 : 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하는 문제
 *       add x: S에 x를 추가한다. (1 ≤ x ≤ 20, 이미 있는 경우 무시)
 *       remove x: S에서 x를 제거한다. (없는 경우 무시)
 *       check x: S에 x가 있으면 1, 없으면 0 출력
 *       toggle x: S에 x가 있으면 제거하고, 없으면 추가
 *       all: 1부터 20까지 모두 추가
 *       empty: S를 공집합으로 만들기
 *
 * 입력 :
 *      - 첫째 줄에 연산의 수 M이 주어진다. (1 ≤ M ≤ 3,000,000)
 *      - 둘째 줄부터 M개의 줄에 연산이 주어진다.
 *
 * 출력 :
 *      - check 연산이 주어질 때마다 결과를 한 줄에 하나씩 출력한다.
 *
 * 문제 풀이 :
 *      - HashSet을 이용하여 연산 처리
 */

public class BOJ_11723 {

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        String command;
        int num;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            num = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;

            Command eCommand = Command.valueOf(command);

            switch (eCommand) {
                case add:
                    set.add(num);
                    break;
                case remove:
                    set.remove(num);
                    break;
                case check:
                    int val = set.contains(num) ? 1 : 0;
                    sb.append(val).append('\n');
                    break;
                case toggle:
                    if(set.contains(num))
                        set.remove(num);
                    else
                        set.add(num);
                    break;
                case all:
                    for (int j = 1; j <= 20; j++)
                        set.add(j);
                    break;
                case empty:
                    set.clear();
                    break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
    }

    private enum Command {
        add, remove, check, toggle, all, empty
    }

}
