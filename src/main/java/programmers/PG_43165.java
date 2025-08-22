package programmers;

import java.io.*;
import java.util.*;

/**
 * 제목: 타겟 넘버
 * 난이도: Level 2
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43165
 *
 * 문제 :
 *      - 숫자가 적힌 정수 배열 numbers와 타겟 넘버 target이 주어진다.
 *      - numbers의 각 숫자 앞에 + 또는 -를 붙여서,
 *        타겟 넘버를 만드는 방법의 수를 구하라.
 *
 * 입력 :
 *      - numbers: 길이 2 이상 20 이하, 원소는 1 이상 50 이하의 자연수
 *      - target: 1 이상 1000 이하의 자연수
 *
 * 출력 :
 *      - 타겟 넘버를 만드는 경우의 수 (정수)
 *
 * 문제 풀이 :
 *      - DFS / BFS 탐색으로 모든 경우의 수를 탐색
 *      - 깊이 우선 탐색 (DFS)로 numbers[i]에 +, -를 붙여 탐색
 */

public class PG_43165 {

    static int count = 0;

    public static int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return count;
    }

    private static void dfs(int[] numbers, int num, int sum, int target) {
        if (num == numbers.length) {
            if (sum == target)
                count++;
        } else {
            dfs(numbers, num + 1, sum + numbers[num], target);
            dfs(numbers, num + 1, sum - numbers[num], target);
        }
    }
}
