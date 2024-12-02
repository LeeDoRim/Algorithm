package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9461_파도반_수열 {

    static int T;
    static long[] progression = new long[100+1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        progression[1] = 1L;
        progression[2] = 1L;
        progression[3] = 1L;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(p(n));
        }

    }

    public static Long p(int n) {
        if (n < 4 || progression[n] != 0L ) return progression[n];

        return progression[n] = p(n-3) + p(n-2);

    }

}
