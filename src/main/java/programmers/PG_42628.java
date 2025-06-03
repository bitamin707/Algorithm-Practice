package programmers;

import java.io.*;
import java.util.*;

/**
 * 제목: 이중우선순위큐
 * 난이도: Level 3
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * <p>
 * 문제 : I 숫자: 숫자를 삽입,
 *       D 1: 최댓값 삭제,
 *       D -1: 최솟값 삭제
 *       명령을 반복 수행한 뒤 남은 값 중 최댓값, 최솟값을 반환하는 문제
 * 입력 :
 *      - 연산을 나타내는 문자열 배열
 *      - 삽입/삭제 명령을 순서대로 수행
 * 출력 : 남아있는 숫자 중 [최댓값, 최솟값] 배열 (없으면 [0, 0])
 * <p>
 * 문제 풀이 :
 *      - TreeMap을 통해 숫자 삽입 시 자동 정렬 수행
 *      - D 명령어에 따른 TreeMap firstKey(), lastkey() 삭제
 *      - 명령어 수행이 끝남에 따른 TreeMap 최대값, 최소값 출력
 *
 */

public class PG_42628 {

    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String operation : operations) {
            String[] split = operation.split(" ");
            String command = split[0];
            int number = Integer.parseInt(split[1]);

            switch (command) {
                case "I":
                    map.put(number, map.getOrDefault(number, 0) + 1);
                    break;

                case "D":
                    if(map.isEmpty()) continue;

                    if(number == 1) {
                        map.remove(map.lastKey());
                    } else {
                        map.remove(map.firstKey());
                    }
                    break;
            }
        }

        if (map.isEmpty()) {
            return new int[] {0, 0};
        }
        return new int[] {map.lastKey(), map.firstKey()};
    }
}
