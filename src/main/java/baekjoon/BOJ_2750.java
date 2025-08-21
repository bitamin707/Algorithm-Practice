package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 수 정렬하기
 * 난이도: 브론즈 2
 * 링크: https://www.acmicpc.net/problem/2750
 *
 * 문제 : N개의 수가 주어졌을 때, 오름차순으로 정렬하여 출력하는 문제.
 *
 * 입력 :
 *      - 첫째 줄에 수의 개수 N (1 ≤ N ≤ 1,000)
 *      - 둘째 줄부터 N개의 줄에 정수 (절댓값 ≤ 1,000)가 하나씩 주어진다.
 *
 * 출력 :
 *      - 주어진 수를 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * 문제 풀이 :
 *      - 입력된 정수를 배열이나 리스트에 저장
 *      - Collections.sort() 또는 Arrays.sort()를 사용하여 정렬
 */


public class BOJ_2750 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for (int n : arr)
            sb.append(n).append("\n");

        bw.write(sb.toString());
        bw.flush();

        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
