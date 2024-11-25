package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2293_동전1 {

    static int N, K;
    static int[] coins, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coins = new int[N + 1];
        dp = new int[K + 1];
        dp[0] = 1;

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
            for(int j=coins[i];j<=K;j++) {
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }

        System.out.println(dp[K]);

    }

}

// 참고 : https://passionfruit200.tistory.com/633