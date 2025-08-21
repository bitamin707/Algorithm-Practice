package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 일곱 난쟁이
 * 난이도: 브론즈 2
 * 링크: https://www.acmicpc.net/problem/2309
 * <p>
 * 문제 :
 *      - 9명의 난쟁이 중 키 합이 100이 되는 7명을 찾는다.
 *      - 7명의 키를 오름차순으로 출력한다.
 * <p>
 * 입력 :
 *      - 9줄에 걸쳐 각 난쟁이의 키가 주어짐 (1 ≤ 키 ≤ 100)
 * <p>
 * 출력 :
 *      - 7명의 키를 오름차순으로 한 줄씩 출력
 * <p>
 * 문제 풀이 :
 *      - 조합(Combination) 또는 완전 탐색
 *      - 9명 중 2명을 제외하고 나머지 합이 100인지 확인
 *      - 오름차순 정렬 후 출력
 */

public class BOJ_2309 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        boolean found = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = arr[j] = -1;
                    found = true;
                    break;
                }
            }

            if (found)
                break;
        }

        Arrays.sort(arr);

        for (int n : arr) {
            if (n != -1)
                sb.append(n).append("\n");
        }

        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
