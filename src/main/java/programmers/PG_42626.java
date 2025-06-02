package programmers;

import java.io.*;
import java.util.*;

/**
 * 제목: 더 맵게
 * 난이도: Level 2
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626
 *
 * 문제 : 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 가장 낮은 두 개를 섞어 새로운 음식을 만드는 작업을 반복하는 문제
 *       가능한 최소 횟수를 구하고, 불가능하면 -1을 반환합니다.
 * 입력 :
 *      - 첫째 줄에 음식들의 스코빌 지수를 나타내는 정수 배열
 *      - 둘째 줄에 목표 스코빌 지수 K (1 ≤ K ≤ 1,000,000,000)
 * 출력 : 모든 음식의 스코빌 지수가 K 이상이 되기 위한 최소 횟수
 *
 * 문제 풀이 :
 *      - PriorityQueue를 이용하여 가장 작은 두 스코빌 지수를 추출
 *      - 두 음식을 섞어 새로운 스코빌 지수를 계산한 후 큐에 삽입
 *      - 큐의 가장 작은 값이 K 이상일 때까지 반복
 *      - 반복 중 큐의 크기가 1인데 K를 못 넘으면 -1
 */

public class PG_42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : scoville) {
            pq.add(val);
        }

        while (pq.size() > 1 && pq.peek() < K) {
            int minVal = pq.poll();
            int secondVal = pq.poll();
            int newScoville = minVal + (secondVal * 2);
            pq.add(newScoville);
            answer++;
        }

        if(pq.peek() < K)
            return -1;

        return answer;
    }

}
