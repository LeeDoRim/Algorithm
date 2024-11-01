package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2448_별_찍기_11 {

    static int N;
    static String[] star;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        star = new String[N];

        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";

        for (int i = 1; 3 * Math.pow(2, i) <= N; i++) {
            writeStar(i);
        }

        for (int i = 0; i < N; i++) {
            System.out.println(star[i]);
        }

    }

    static void writeStar(int i) {
        int bottom = (int) (3 * Math.pow(2, i));
        int middle = bottom / 2;

        // 별 점화식
        for (int j = middle; j < bottom; j++) {
            star[j] = star[j - middle] + " " + star[j - middle];
        }

        String blank = " ".repeat(middle);

        // 빈칸 추가
        for (int j = 0; j < middle; j++) {
            star[j] = blank + star[j] + blank;
        }
    }

}

// 참고 : https://tussle.tistory.com/1000