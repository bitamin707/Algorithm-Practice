package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 프린터 큐
 * 난이도: 실버 3
 * 링크: https://www.acmicpc.net/problem/1966
 *
 * 문제 : 중요도가 높은 문서를 먼저 인쇄하는 프린터 구현 문제
 * 입력 :
 *      - 첫 줄에 테스트 케이스의 수가 주어진다.
 *      - 문서의 개수 N (1 <= N <= 100)
 *      - 몇 번째로 인쇄되었는지 궁금한 문서 M (0 <= M < N)
 *      - 두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다.
 * 출력 : 각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력한다.
 *
 * 문제 풀이 :
 *      - 문서들의 중요도를 그대로 큐에 넣어 순서대로 관리
 *      - importanceArray를 역순 정렬한 deorderImportList를 별도로 생성
 *      - queue.peek()이 현재 최상위 중요도(deorderImportList.get(0)과 같다면 출력
 *      - 내가 궁금한 문서의 위치를 targetIndex로 관리하고
 *      - 문서를 꺼낼 때마다 targetIndex를 큐의 순서에 맞게 갱신
 *      - 문서가 출력될 때 targetIndex == 0 이면 내가 궁금한 문서가 출력된 것으로
 *      - 출력 순서인 printCount를 반환
 */
public class BOJ_1966 {
    public static int solve(int n, int m, int[] importanceArray) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> deorderImportList = getSortedImportanceList(importanceArray);
        int targetIndex = m;
        int printCount = 1;

        for (int i : importanceArray) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            if(queue.peek() == deorderImportList.get(0)) {
                queue.poll(); // 문서 출력
                deorderImportList.remove(0); // 가장 큰 중요도 제거
                
                if(targetIndex == 0) {
                    return printCount;
                }
                
                printCount++; // 출력된 문서가 타겟이 아닌 경우 증가
            } else {
                queue.add(queue.poll());
            }
            targetIndex = targetIndex == 0 ? queue.size() - 1 : targetIndex - 1; // 인덱스 추적
        }
        return -1;
    }

    // 중요도 역순으로 정렬
    private static List<Integer> getSortedImportanceList(int[] importanceArray) {
        List<Integer> list = new ArrayList<>();
        for (int i : importanceArray) {
            list.add(i);
        }
        list.sort(Collections.reverseOrder());
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        int n, m;
        int[] importance;

        for(int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            importance = new int[n];
            for(int j = 0; j < n; j++) {
                importance[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solve(n, m, importance));
        }
    }
}
