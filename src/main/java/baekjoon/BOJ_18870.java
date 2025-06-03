package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 좌표 압축
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/18870
 *
 * 문제 : 수열에서 값의 상대적 순위를 기준으로 좌표를 압축한 결과를 출력하는 문제
 *        값이 큰 순서가 아니라, 중복을 제거하고 정렬한 후 인덱스를 부여하는 방식
 * 입력 :
 *      - 첫째 줄에 수열의 크기 N (1 ≤ N ≤ 1,000,000)
 *      - 둘째 줄에 공백으로 구분된 정수 N개
 * 출력 : 각 수가 압축된 좌표로 변환된 결과를 한 줄에 출력
 *
 * 문제 풀이 :
 *      - 입력된 좌표를 posX 배열에 저장, TreeSet을 사용해 중복 제거 및 오름차순 정렬
 *      - 정렬된 TreeSet을 각 좌표 값에 대해 압축된 인덱스를 매칭한 HashMap 생성
 *      - posX를 순회하며 HashMap에 해당하는 값의 인덱스 출력
 */

public class BOJ_18870 {
    public static String solve(String input) throws IOException {
                BufferedReader br = new BufferedReader(new StringReader(input));
                int testCase = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());
                StringBuilder sb = new StringBuilder();

                int[] posX = new int[st.countTokens()];
                Set<Integer> set = new TreeSet<>();

                for (int i = 0; i < testCase; i++) {
                    posX[i] = Integer.parseInt(st.nextToken());
                    set.add(posX[i]);
                }

                Map<Integer, Integer> map = new HashMap<>();
                int index = 0;
                for (int val : set) {
                    map.put(val, index++);
                }

                for (int i = 0; i < posX.length; i++) {
                    sb.append(map.get(posX[i])).append(' ');
                }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
    }
}
