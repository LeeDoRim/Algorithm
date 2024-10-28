package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2133_타일_채우기 {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        if(N % 2 == 1) {
            System.out.println(0);
            return;
        }

        dp[2] = 3;
        for(int i = 4; i <= N; i+=2) {
            dp[i] = dp[i-2] * 3 + 2;
            for(int j = i-2; j >= 4; j-=2) {
                dp[i] += dp[i-j] * 2;
            }
        }

        System.out.println(dp[N]);
    }

}

// 참고 : https://january-diary.tistory.com/entry/BOJ-2133-%ED%83%80%EC%9D%BC-%EC%B1%84%EC%9A%B0%EA%B8%B0-JAVA