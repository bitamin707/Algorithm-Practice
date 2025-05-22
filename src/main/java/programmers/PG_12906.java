package programmers;

import java.util.*;

/**
 * 제목: 같은 숫자는 싫어
 * 난이도: Level 1
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12906
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
