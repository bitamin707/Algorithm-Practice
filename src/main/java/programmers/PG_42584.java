package programmers;

import java.util.*;

/**
 * 제목: 주식가격
 * 난이도: Level 2
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42584
 *
 * 문제 : 주식 가격이 떨어지지 않는 기간을 계산하는 문제
 * 입력 :
 *      - prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 *      - prices의 길이는 2 이상 100,000 이하입니다.
 *      - 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때
 * 출력 : 가격이 떨어지지 않는 기간은 몇 초인지 return 한다.
 * 입출력 예 :
 *      - prices : [1, 2, 3, 2, 3]
 *      - return : [4, 3, 1, 1, 0]
 * 입출력 예 설명 :
 *      - 1초의 주가는 1이며 1초부터 5초까지 총 4초간 주가를 유지했습니다.
 *      - 2초의 주가는 2이며 2초부터 5초까지 총 3초간 주가를 유지했습니다.
 *      - 3초의 주가는 3이며 4초의 주가는 2로 주가가 떨어졌지만 3초에서 4초가 되기 직전까지의 1초간 주가가 유지 된것으로 봅니다.
 *        따라서 5초까지 총 1초간 주가를 유지했습니다.
 *      - 4초의 주가는 2이며 4초부터 5초까지 총 1초간 주가를 유지했습니다.
 *      - 5초의 주가는 3이며 5초 이후로는 데이터가 없으므로 총 0초간 주가를 유지했습니다.
 *
 * 문제 풀이 :
 *      - 각 시점 i 에서
 *      - 가격이 떨어지는 시점을 만날 때까지 기다림
 *      - 가격이 떨어지는 순간이 오면 스택에 저장된 과거 인덱스들의 유지 시간을 계산
 *      - 스택에는 아직 가격이 떨어지지 않은 인덱스만 유지
 *      - 마지막까지 떨어지지 않은 경우 남은시간은 prices.length - index - 1로 계산
 */

public class PG_42584 {
    public int[] solution(int[] prices) {
        Stack<Integer> maintainSec = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            while (!maintainSec.isEmpty() && prices[i] < prices[maintainSec.peek()]) {
                int index = maintainSec.pop();
                answer[index] = i - index;
            }
            maintainSec.push(i);
        }

        while(!maintainSec.isEmpty()) {
            int index = maintainSec.pop();
            answer[index] = prices.length - index - 1;
        }

        return answer;
    }
}
