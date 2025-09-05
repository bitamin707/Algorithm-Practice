package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 색종이 만들기
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/2630
 *
 * 문제 :
 *      - N×N 크기의 정사각형 종이가 하얀색(0) 또는 파란색(1)으로 칠해져 있음
 *      - 종이를 일정한 규칙에 따라 잘라서 하얀색 또는 파란색 색종이를 만들려고 함
 *      - 전체 종이가 모두 같은 색이 아니면 N/2 × N/2 크기의 네 개 색종이로 나눔
 *      - 나누어진 각 색종이에 대해서도 같은 방법으로 반복
 *      - 모두 같은 색이거나 더 이상 자를 수 없을 때까지 반복
 *
 * 입력 :
 *      - 첫째 줄: 전체 종이의 한 변의 길이 N (N = 2^k, 1 ≤ k ≤ 7)
 *      - N은 2, 4, 8, 16, 32, 64, 128 중 하나
 *      - 둘째 줄부터 N줄: 각 줄에 N개의 색깔 정보 (0: 하얀색, 1: 파란색)
 *      - 각 숫자 사이에는 빈칸이 하나씩 있음
 *
 * 출력 :
 *      - 첫째 줄: 잘라진 하얀색 색종이의 개수
 *      - 둘째 줄: 파란색 색종이의 개수
 *
 * 문제 풀이 :
 *      - 분할정복(Divide and Conquer) 알고리즘 활용
 *      - 재귀 함수로 구현: 현재 영역이 모두 같은 색인지 확인
 *      - 같은 색이면 해당 색종이 개수 증가
 *      - 다른 색이 섞여 있으면 4등분하여 재귀 호출
 *      - 시작 좌표(x, y)와 크기(size)를 매개변수로 전달
 */

public class BOJ_2630 {

    private static int whiteCount = 0;
    private static int blueCount = 0;

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        recursion(matrix, 0, 0, N);

        sb.append(whiteCount).append("\n");
        sb.append(blueCount);
        System.out.println(sb);
        return sb.toString();
    }

    private static void recursion(int[][] matrix, int x, int y, int length) {
        int count = 0;

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (matrix[i][j] == 1)
                    count++;
            }
        }

        if (count == length * length)
            blueCount++;
        else if (count == 0)
            whiteCount++;
        else {
            int nextLength = length / 2;

            recursion(matrix, x, y, nextLength);
            recursion(matrix, x, y + length / 2, nextLength);
            recursion(matrix, x + length / 2, y, nextLength);
            recursion(matrix, x + length / 2, y + length / 2, nextLength);
        }
    }


    public static void main(String[] args) {
    }
}