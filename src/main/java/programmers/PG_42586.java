package programmers;

import java.util.*;

/**
 * 제목: 기능개발
 * 난이도: Level 2
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */

public class PG_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remaining = (100 - progresses[i]);
            int day = (int) Math.ceil((double) remaining / speeds[i]);
            queue.add(day);
        }

        while (!queue.isEmpty()) {
            int day = queue.poll();
            int count = 1;

            while (!queue.isEmpty() && queue.peek() <= day) {
                count++;
                queue.poll();
            }
            result.add(count);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
