package programmers;

import java.util.*;

/**
 * 제목: 기능개발
 * 난이도: Level 2
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */

public class PG_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int count, index = 0;

        for (int i : progresses) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            count = 0;
            for(int i = index; i < speeds.length; i++) {
                queue.add(queue.poll() + speeds[i]);
            }

            while (!queue.isEmpty()) {
                if(queue.peek() >= 100) {
                    queue.poll();
                    count++;
                    index++;
                } else {
                    break;
                }
            }

            if(count != 0){
                result.add(count);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
