package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 제목: 회의실 배정
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/1931
 *
 * 문제 :
 *      - 한 개의 회의실에 N개의 회의를 배정하여 최대한 많은 회의를 진행
 *      - 각 회의는 시작시간과 끝나는 시간이 주어짐
 *      - 회의가 겹치지 않게 하면서 최대 개수의 회의를 찾기
 *      - 한 회의가 끝나는 것과 동시에 다음 회의가 시작 가능
 *
 * 입력 :
 *      - 첫째 줄: 회의의 수 N (1 ≤ N ≤ 100,000)
 *      - 둘째 줄부터 N+1 줄: 각 회의의 시작시간과 끝나는 시간
 *      - 시간은 2³¹-1보다 작거나 같은 자연수 또는 0
 *
 * 출력 :
 *      - 회의실을 사용할 수 있는 회의의 최대 개수
 *
 * 문제 풀이 :
 *      - 그리디 알고리즘 (Activity Selection Problem)
 *      - 끝나는 시간 순으로 정렬 (끝나는 시간이 같으면 시작시간 순)
 *      - 끝나는 시간이 빠른 회의를 우선적으로 선택
 *      - 이전 회의의 끝나는 시간 <= 다음 회의의 시작시간인 경우에만 선택
 */

public class BOJ_1931 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prev_end = 0;

        for (int i = 0; i < N; i++) {
            if (prev_end <= times[i][0]) {
                prev_end = times[i][1];
                count++;
            }
        }

        System.out.println(count);
        return String.valueOf(count);
    }

    public static void main(String[] args) {
    }
}

