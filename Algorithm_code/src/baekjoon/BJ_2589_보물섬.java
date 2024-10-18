package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2589_보물섬 {

    static int N, M, answer = 0;
    static char[][] map;
    static boolean[][] visited;

    static class Pair {
        int x, y, cost;

        public Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[N][M];
                    bfs(new Pair(i, j, 0));
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(Pair p) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(p);
        visited[p.x][p.y] = true;

        while (!queue.isEmpty()) {
            Pair nextP = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = nextP.x + dx[i];
                int ny = nextP.y + dy[i];

                if (validationCheck(nx, ny) && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    queue.offer(new Pair(nx, ny, nextP.cost + 1));
                    answer = Math.max(answer, nextP.cost + 1);
                }
            }
        }
    }

    static boolean validationCheck(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }

}

// 참고 : https://devtech-ocean.tistory.com/12