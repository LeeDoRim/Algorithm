package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14567_선수과목 {

    static int N, M;
    static int[] dp, in;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        in = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            in[b]++;
        }

        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) {
                dp[i] = 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                int node = list[i].get(j);
                dp[node] = Math.max(dp[node], dp[i] + 1);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(dp[i] + " ");
        }

    }

}

// 참고 : https://stritegdc.tistory.com/366