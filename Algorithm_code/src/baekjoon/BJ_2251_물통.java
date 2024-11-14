package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2251_물통 {

    static int A, B, C;
    static boolean[][][] visited;
    static boolean[] answer;
    static int[] from = {0, 0, 1, 1, 2, 2};
    static int[] to = {1, 2, 0, 2, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[A + 1][B + 1][C + 1];
        answer = new boolean[C + 1];

        bfs();

        for (int i = 0; i <= C; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, C});
        visited[0][0][C] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int a = cur[0], b = cur[1], c = cur[2];

            if (a == 0) answer[c] = true;

            for (int i = 0; i < 6; i++) {
                int[] next = {a, b, c};
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;

                if (next[to[i]] > new int[]{A, B, C}[to[i]]) {
                    next[from[i]] = next[to[i]] - new int[]{A, B, C}[to[i]];
                    next[to[i]] = new int[]{A, B, C}[to[i]];
                }

                if (!visited[next[0]][next[1]][next[2]]) {
                    visited[next[0]][next[1]][next[2]] = true;
                    queue.offer(next);
                }
            }
        }
    }

}

// 참고 : https://jsw5913.tistory.com/181