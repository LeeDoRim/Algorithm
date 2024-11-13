package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1010_다리_놓기 {

    private final static int MAX = 30; //N과 M이 30까지만 입력받기 때문에
    static int[][] dp = new int[MAX + 1][MAX + 1]; //조합을 계산할 때 사용하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); //테스트 개수

        createCombie(); //조합 구하는 배열 만들기

        //테스트 개수만큼  다리를 지을 수 있는 경우의 수 구하기
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            System.out.println(dp[n][r]);
        }

    }

    static void createCombie(){ //조합 배열 만드는 메소드
        //nC1 = n인 속성을 이용
        for (int i = 1; i <= MAX; i++) {
            dp[i][1] = i;
        }

        //nCr = n-1Cr-1 + n-1Cr의 속성을 이용
        for (int j = 2; j <= MAX; j++) {
            for (int k = 2; k <= MAX; k++) {
                dp[j][k] = dp[j - 1][k - 1] + dp[j - 1][k];
            }
        }
    }

}

// 참고 : https://velog.io/@gayeong39/%EB%B0%B1%EC%A4%80-1010-%EB%8B%A4%EB%A6%AC-%EB%86%93%EA%B8%B0-JAVA