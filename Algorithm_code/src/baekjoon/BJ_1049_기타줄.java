package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1049_기타줄 {

    static int N, M, minSet = 1000, minOne = 1000;
    static int[][] brand;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        brand = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            brand[i][0] = Integer.parseInt(st.nextToken());
            brand[i][1] = Integer.parseInt(st.nextToken());

            if(brand[i][0] < minSet) minSet = brand[i][0];
            if(brand[i][1] < minOne) minOne = brand[i][1];
        }

        int answer = 0;
        if(minSet > minOne * 6) {
            answer = N * minOne;
        }
        else {
            answer = Math.min(minSet * (N / 6 + 1) , (minSet * (N / 6)) + (minOne * (N % 6)));
        }

        System.out.println(answer);

    }

}

// 참고 : https://cladren123.tistory.com/293?category=1051326
