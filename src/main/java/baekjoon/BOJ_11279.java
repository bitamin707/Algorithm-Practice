package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 최대 힙
 * 난이도: 실버 2
 * 링크: https://www.acmicpc.net/problem/11279
 *
 * 문제 :
 *      - 최대 힙을 이용하여 두 가지 연산을 지원하는 프로그램 작성
 *      - 배열에 자연수 x를 넣는다
 *      - 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다
 *      - 프로그램은 처음에 비어있는 배열에서 시작
 *
 * 입력 :
 *      - 첫째 줄: 연산의 개수 N (1 ≤ N ≤ 100,000)
 *      - 다음 N개의 줄: 연산에 대한 정보를 나타내는 정수 x
 *      - x가 자연수라면 배열에 x 추가, x가 0이라면 가장 큰 값 출력 후 제거
 *      - 입력되는 자연수는 2^31보다 작음
 *
 * 출력 :
 *      - 입력에서 0이 주어진 횟수만큼 답을 출력
 *      - 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력
 *
 * 문제 풀이 :
 *      - 우선순위 큐(Priority Queue) 또는 힙(Heap) 자료구조 활용
 *      - Java에서는 PriorityQueue를 역순으로 정렬하여 최대 힙 구현
 *      - Collections.reverseOrder() 또는 (a, b) -> b - a 비교자 사용
 *      - 삽입과 삭제 연산 모두 O(log N) 시간복잡도
 *      - 빈 힙에서 pop 연산 시 0 출력 처리 필요
 */

public class BOJ_11279 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (queue.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(queue.poll()).append("\n");
            } else
                queue.offer(num);
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}
