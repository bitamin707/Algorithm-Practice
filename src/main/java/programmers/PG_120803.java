package programmers;

/**
 * 제목: 두 수의 차
 * 난이도: Level 0
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120803
 *
 * 문제 :
 *      - 정수 num1과 num2가 주어질 때, num1에서 num2를 뺀 값을 return
 *
 * 입력 :
 *      - num1: 첫 번째 정수 (-50000 ≤ num1 ≤ 50000)
 *      - num2: 두 번째 정수 (-50000 ≤ num2 ≤ 50000)
 *
 * 출력 :
 *      - num1 - num2의 결과값
 *
 * 문제 풀이 :
 *      - 단순한 뺄셈 연산
 */

public class PG_120803 {
    public static int solution(int num1, int num2) {
        int answer = num1 - num2;
        return answer;
    }
}
