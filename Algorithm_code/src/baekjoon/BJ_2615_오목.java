package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2615_오목 {

    static int[][] map = new int[19][19];
    static boolean[][] visited = new boolean[19][19];
    static int[] dx = {1, -1, 0, 1}; // 하, 오른쪽상 대각선, 오른쪽, 오른쪽하 대각선
    static int[] dy = {0, 1, 1, 1};
    static int result;
    static boolean flag = false; // 6목인지 확인하는 flag

    static class Node {
        int x;
        int y;
        int color;

        Node (int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] != 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        flag = false;
                        dfs(new Node(i, j, map[i][j]), 1, dir);

                        // 6목이 아닌 경우
                        // 오목의 입장에서 반대방향의 오목 한 칸이 존재하는지 확인 필요
                        if (!flag) {
                            // 반대방향 확인
                            int nx = i - dx[dir];
                            int ny = j - dy[dir];
                            int color = map[i][j];

                            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                                if (map[nx][ny] == color) { // 다음 칸이 같은 색이면 flag = ture
                                    result = 0;
                                }
                            }

                            if (result != 0) {
                                System.out.println(result);
                                System.out.println((i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);

    }

    static void dfs(Node node, int cnt, int direction) {
        if (cnt == 5) {
            int nx = node.x + dx[direction];
            int ny = node.y + dy[direction];
            int color = node.color;

            // 다음 칸에서 범위를 벗어나면 성공한 것으로 처리
            if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) {
                result = node.color;
                return;
            }

            // 다음 칸이 같은 색이면 6목 -> 실패
            if (map[nx][ny] == color) {
                flag = true;
                return;
            }

            // 다음 칸의 색이 다른 것이면 성공
            // 다음 것이 존재하는지 확인하여 flag = false로 유지
            if (map[nx][ny] != color) {
                result = node.color;
                return;
            }
        }

        // 같은 방향의 다음 칸 확인
        int nx = node.x + dx[direction];
        int ny = node.y + dy[direction];
        int color = node.color;
        if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) return;
        if (map[nx][ny] != color) return;
        if (visited[nx][ny]) return;

        visited[nx][ny] = true;
        dfs(new Node(nx, ny, color), cnt + 1, direction);
        if (!flag) {
            visited[nx][ny] = false;
        }
    }
}

// 참고 : https://velog.io/@godqhrals/JAVA-%EB%B0%B1%EC%A4%80-2615%EB%B2%88-%EC%98%A4%EB%AA%A9