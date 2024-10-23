package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1966_프린터_큐 {

    static int T, N, M;
    static int[] printerQueue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            printerQueue = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                printerQueue[i] = Integer.parseInt(st.nextToken());
            }

            int result = 1;
            int pointer = 0;

            while (result < N) {
                int temp = pointer;
                for (int i = temp; i < temp + N; i++) {
                    int nP = (i + N) % N;
                    if (printerQueue[nP] > printerQueue[pointer]) {
                        pointer = nP;
                    }
                }
                if (pointer == M) {
                    break;
                } else {
                    result++;
                    printerQueue[pointer] = 0;
                }
            }

            System.out.println(result);

        }

    }

}
