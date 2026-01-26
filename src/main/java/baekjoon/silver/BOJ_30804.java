package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 과일 탕후루
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/30804
 *
 * 문제 :
 *      - N개의 과일이 꽂혀있는 탕후루에서 앞뒤로 몇 개의 과일을 빼서
 *      - 최대 두 종류의 과일만 남도록 하여 가장 긴 탕후루를 만드는 문제
 *      - 과일 종류는 1~9번으로 표현됨
 *
 * 입력 :
 *      - 첫째 줄: 과일의 개수 N (1 ≤ N ≤ 200,000)
 *      - 둘째 줄: N개의 과일 번호 (1 ≤ Si ≤ 9)
 *
 * 출력 :
 *      - 두 종류 이하의 과일로 구성된 가장 긴 탕후루의 과일 개수
 *
 * 문제 풀이 :
 *      - 투 포인터(Two Pointer) 또는 슬라이딩 윈도우 기법 사용
 *      - 연속된 부분 배열에서 최대 2개의 서로 다른 숫자로만 구성된 최대 길이 찾기
 *      - HashMap을 사용하여 현재 구간의 과일 종류와 개수 관리
 */

public class BOJ_30804 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            list[i] = Integer.parseInt(st.nextToken());

        int left = 0, maxLength = 0;

        for (int right = 0; right < N; right++) {
            map.put(list[right], map.getOrDefault(list[right], 0) + 1);

            while (map.size() > 2) {
                map.put(list[left], map.getOrDefault(list[left], 0) - 1);
                if (map.get(list[left]) == 0)
                    map.remove(list[left]);

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
        return String.valueOf(maxLength);
    }

    public static void main(String[] args) {
    }
}
