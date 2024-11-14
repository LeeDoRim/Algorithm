package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15565_귀여운_라이언 {

    static int N, K, result = Integer.MAX_VALUE;
    static int[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for(int start = 1, end = 1; start < N; start++) {
            while(end < N && count < K) {
                if(list[end] == 1) {
                    count++;
                }
                end++;
            }

            if(count == K) {
                result = Math.min(result, end - start);
            }

            if(list[start] == 1) {
                count--;
            }
        }

        if(result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);

    }

}

// 참고 : https://daon-programming.tistory.com/215