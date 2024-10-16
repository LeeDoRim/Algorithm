package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_13023_ABCDE {

    static int N, M, answer = 0;
    static ArrayList<Integer>[] edgeList;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        edgeList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edgeList[a].add(b);
            edgeList[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if (answer != 1) dfs(i, 1);
        }

        System.out.println(answer);

    }

    public static void dfs(int start, int depth) {
        if (depth == 5) {
            answer = 1;
            return;
        }

        visited[start] = true;
        for (int to : edgeList[start] ) {
            if (!visited[to]) dfs(to, depth + 1);
        }

        visited[start] = false;
    }

}

// 참고 : https://velog.io/@tomy8964/%EB%B0%B1%EC%A4%80-13023%EB%B2%88-ABCDE-JAVA-%EC%9E%90%EB%B0%94