package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_20364_부동산_다툼 {

    static int N, Q;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];

        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();

            while (num > 1) {
                stack.push(num);
                num /= 2;
            }

            while (!visited[stack.peek()]) {
                int num1 = stack.pop();
                if(stack.isEmpty()) {
                    visited[num1] = true;
                    System.out.println(0);
                    break;
                }
            }

            if(!stack.isEmpty()) {
                System.out.println(stack.peek());
            }

        }
    }

}
