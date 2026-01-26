package baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 제목: 이중 우선순위 큐
 * 난이도: 골드 5
 * 링크: https://www.acmicpc.net/problem/7662
 *
 * 문제 :
 *      - 이중 우선순위 큐는 데이터를 삽입, 삭제할 수 있는 자료구조
 *      - 삭제할 때 최댓값 또는 최솟값 중 하나를 선택적으로 삭제 가능
 *      - I n: 정수 n을 큐에 삽입
 *      - D 1: 큐에서 최댓값을 삭제
 *      - D -1: 큐에서 최솟값을 삭제
 *      - 모든 연산 후 큐에 남은 최댓값과 최솟값 출력
 *
 * 입력 :
 *      - 첫째 줄: 테스트 케이스 개수 T (T ≤ 1,000,000)
 *      - 각 테스트 케이스마다:
 *        - 첫째 줄: 연산의 개수 k (k ≤ 1,000,000)
 *        - 다음 k줄: 연산 정보 (I n 또는 D 1 또는 D -1)
 *
 * 출력 :
 *      - 각 테스트 케이스마다 최댓값과 최솟값을 공백으로 구분하여 출력
 *      - 큐가 비어있으면 "EMPTY" 출력
 *
 * 문제 풀이 :
 *      - TreeMap 사용: 자동 정렬되는 Map (key: 값, value: 개수)
 *      - 중복 값 처리: 같은 값이 여러 번 삽입될 수 있으므로 개수 관리
 *      - 삭제 시 개수를 줄이고, 개수가 0이 되면 완전 삭제
 */

public class BOJ_7662 {
    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        TreeMap<Integer, Integer> map;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            map = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else if (cmd.equals("D") && map.isEmpty())
                    continue;
                else if (cmd.equals("D") && num == 1) {
                    int maxKey = map.lastKey();
                    if (map.get(maxKey) == 1)
                        map.remove(maxKey);
                    else
                        map.put(maxKey, map.get(maxKey) - 1);
                } else if (cmd.equals("D") && num == -1) {
                    int minKey = map.firstKey();
                    if (map.get(minKey) == 1)
                        map.remove(minKey);
                    else
                        map.put(minKey, map.get(minKey) - 1);
                }
            }

            if (map.isEmpty())
                sb.append("EMPTY").append("\n");
            else
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
    }
}