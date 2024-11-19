package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로_탐색 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static final int[] dy = {1, 0, -1, 0};
    static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String inputStr = st.nextToken();

            for (int j = 0; j < M; j++) {
                map[i][j] = inputStr.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]);

    }

    private static void bfs(int mapY, int intX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{mapY, intX});

        while (!queue.isEmpty()) {
            int[] curXY = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int ny = dy[i] + curXY[0];
                int nx = dx[i] + curXY[1];
                int curMin = map[curXY[0]][curXY[1]];

                if (0 <= nx && nx < M && 0 <= ny && ny < N && map[ny][nx] == 1 && !visited[ny][nx]) {
                    map[ny][nx] = curMin + 1;
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

}

// 참고 : https://deftkang.tistory.com/268