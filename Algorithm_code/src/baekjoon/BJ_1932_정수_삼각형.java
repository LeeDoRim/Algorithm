package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1932_정수_삼각형 {

    static int N, result = 0;
    static int[][] triangle, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if (j == j+i) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            if(result < dp[N-1][i]) result = dp[N-1][i];
        }

        System.out.println(result);

    }

}

// 참고 : https://velog.io/@tlsdmsgp33/%EB%B0%B1%EC%A4%80-1932%EB%B2%88-%EC%A0%95%EC%88%98-%EC%82%BC%EA%B0%81%ED%98%95-java-%ED%92%80%EC%9D%B4