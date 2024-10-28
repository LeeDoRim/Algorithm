package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012_유기농_배추 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0}; // 위, 아래, 왼, 오
    static int[][] map;
    static boolean[][] visit;
    static int n, m, k, count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < t; i++){
            count = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            visit = new boolean[m][n];

            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a][b] = 1;
            }

            for(int j = 0; j < m; j++){
                for(int l = 0; l < n; l++){
                    if(map[j][l] == 1 && !visit[j][l]){
                        bfs(j, l);
                        count++; // 조건에 맞아서 내부로 들어오면 count를 증가하고 해당하는 값과 인접한 곳에 대해서는 dfs 함수를 통해 visit 배열에 값을 넣는다.
                    }
                }
            }

            System.out.println(count);

        }

    }

    public static void bfs(int a, int b){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {a, b});

        while(!queue.isEmpty()){
            a = queue.peek()[0];
            b = queue.peek()[1];

            visit[a][b] = true;
            queue.poll(); // [0]과 [1] 모두 없앰
            for(int i = 0; i < 4; i++){
                int next_a = a + dx[i];
                int next_b = b + dy[i];

                if(next_b >= 0 && next_a >= 0 && next_a < m && next_b < n){
                    if(map[next_a][next_b] == 1 && !visit[next_a][next_b]){
                        queue.add(new int[]{next_a, next_b});
                        visit[next_a][next_b] = true;
                    }
                }
            }
        }

    }

}

// 참고 : https://plum-king.tistory.com/73
