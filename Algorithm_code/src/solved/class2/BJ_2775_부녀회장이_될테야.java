package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2775_부녀회장이_될테야 {

    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            int[][] apt = new int[K+1][N+1];
            for (int j = 1; j < N+1; j++) {
                apt[0][j] = j;
            }

            for (int j = 1; j < K+1; j++) {
                for (int k = 1; k < N+1; k++) {
                    int peopleCount = 0;
                    for (int l = 1; l <= k; l++) {
                        peopleCount += apt[j-1][l];
                    }
                    apt[j][k] = peopleCount;
                }
            }

            System.out.println(apt[K][N]);
        }
    }

}
