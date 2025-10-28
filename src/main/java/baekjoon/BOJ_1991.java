package baekjoon;

import java.io.*;
import java.util.*;

/**
 * 제목: 트리 순회
 * 난이도: 실버 1
 * 링크: https://www.acmicpc.net/problem/1991
 *
 * 문제 :
 *      - 이진 트리를 입력받아 전위, 중위, 후위 순회 결과 출력
 *      - 노드는 A부터 시작하는 알파벳 대문자
 *      - 자식이 없으면 '.'으로 표시
 *
 * 입력 :
 *      - 첫째 줄: 노드의 개수 N (1 ≤ N ≤ 26)
 *      - 둘째 줄~N개 줄: 각 노드와 왼쪽 자식, 오른쪽 자식
 *        (노드 이름은 중복되지 않으며, A는 항상 루트)
 *
 * 출력 :
 *      - 첫째 줄: 전위 순회 결과
 *      - 둘째 줄: 중위 순회 결과
 *      - 셋째 줄: 후위 순회 결과
 *
 * 문제 풀이 :
 *      - 재귀를 이용한 트리 순회
 *      - 전위 순회(Preorder): 루트 → 왼쪽 → 오른쪽
 *      - 중위 순회(Inorder): 왼쪽 → 루트 → 오른쪽
 *      - 후위 순회(Postorder): 왼쪽 → 오른쪽 → 루트
 */

public class BOJ_1991 {

    static StringBuilder sb;
    static Node[] tree;

    static class Node {
        char value;
        Node left, right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static String solve(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[root - 'A'] == null)
                tree[root - 'A'] = new Node(root);
            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[root - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[root - 'A'].right = tree[right - 'A'];
            }
        }

        preoder(tree[0]);
        sb.append("\n");
        inoder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);
        sb.append("\n");

        System.out.println(sb);
        return sb.toString();
    }

    private static void preoder(Node node) {
        if (node == null)
            return;
        sb.append(node.value);
        preoder(node.left);
        preoder(node.right);
    }

    private static void inoder(Node node) {
        if (node == null)
            return;
        inoder(node.left);
        sb.append(node.value);
        inoder(node.right);
    }

    private static void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }

    public static void main(String[] args) {
    }
}
