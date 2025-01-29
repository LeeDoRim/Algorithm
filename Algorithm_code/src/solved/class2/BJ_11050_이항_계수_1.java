package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11050_이항_계수_1 {

    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int n = 1;
        for (int i = N; i > 1; i--) {
            n *= i;
        }

        int k = 1;
        for (int i = K; i > 1; i--) {
            k *= i;
        }

        int nk = 1;
        for (int i = N - K; i > 1; i--) {
            nk *= i;
        }

        System.out.println( n / (nk * k) );

    }

}
