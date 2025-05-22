package programmers;

import java.util.*;

/**
 * [PG 12906] 같은 숫자는 싫어
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 *
 * ▪ 문제 유형: 자료 구조
 * ▪ 문제 개요:
 *   - 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거한다.
 *   - 제거된 후 남은 수들을 arr의 원소 순서를 유지하며 출력한다.
 *
 */

public class PG_12906 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;

        for (int num : arr) {
            if(num != prev) {
                list.add(num);
                prev = num;
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
