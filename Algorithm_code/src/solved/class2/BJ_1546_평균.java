package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1546_평균 {

    static int N, Max = 0;
    static int[] score;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        score = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            if (score[i] > Max) Max = score[i];
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (double) score[i] / Max * 100;
        }

        System.out.println(sum / N);
    }

}
