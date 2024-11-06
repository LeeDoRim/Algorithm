package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2777_숫자놀이 {

    static int T, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            int idx = 9, answer = 0;

            if (N == 1) {
                System.out.println(1);
                continue;
            }

            while (idx > 1) {
                if (N % idx == 0) {
                    N /= idx;
                    answer++;
                } else {
                    idx--;
                }
            }

            if (N != 1) System.out.println(-1);
            else System.out.println(answer);

        }

    }

}

// 참고 : https://melody-coding.tistory.com/m/597