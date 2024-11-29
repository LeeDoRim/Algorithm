package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1449_수리공_항승 {

    static int N, L, tapeCount = 1;
    static int[] pipe;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        pipe = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pipe[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(pipe);

        double tape = (pipe[0] - 0.5) + L;
        for (int i = 1; i < N; i++) {
            if ( tape < (pipe[i] + 0.5) ) {
                tapeCount++;
                tape = (pipe[i] - 0.5) + L;
            }
        }

        System.out.println(tapeCount);

    }

}

// 참고 : https://kne-coding.tistory.com/222