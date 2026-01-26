package baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 제목: 나는야 포켓몬 마스터 이다솜
 * 난이도: 실버 4
 * 링크: https://www.acmicpc.net/problem/1620
 *
 * 문제 : N개의 포켓몬 이름과 번호가 주어지고, M개의 문제(질문)가 주어졌을 때,
 *       문제로 주어지는 이름 또는 번호에 대해 매칭되는 결과를 출력하는 문제
 *
 * 입력 :
 *      - 첫째 줄에 N과 M이 주어진다. (1 ≤ N, M ≤ 100,000)
 *      - 둘째 줄부터 N개의 줄에 포켓몬 이름이 1번부터 N번까지 순서대로 주어진다.
 *      - 그 다음 M개의 줄에는 문제(이름 또는 번호)가 주어진다.
 *
 * 출력 :
 *      - 문제로 주어진 이름에 대해선 번호를, 번호에 대해선 이름을 출력한다.
 *        각 줄에 하나씩 출력
 *
 * 문제 풀이 :
 *      - 주어진 입력 값들을 양방향 맵으로 구성
 *      - 숫자면 배열에서 찾아서 이름 출력
 *      - 문자면 해쉬맵에서 찾아서 번호 출력
 */


public class BOJ_1620 {

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        HashMap<String, Integer> nameToNum = new HashMap<>();
        String[] numToName = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            String poke = br.readLine();
            nameToNum.put(poke, i);
            numToName[i] = poke;
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if(isNumber(s)) {
                sb.append(numToName[Integer.parseInt(s)]).append("\n");
            } else {
                sb.append(nameToNum.get(s)).append("\n");
            }
        }
        System.out.print(sb);
        return sb.toString();
    }

    private static boolean isNumber(String str) {
        return str.matches("\\d+");
    }

    public static void main(String[] args) {

    }
}
