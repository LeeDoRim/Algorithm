package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_색종이_만들기 {

    static int N, white = 0, blue = 0;
    static int[][] paper;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(0, 0,  N);

        System.out.println(white);
        System.out.println(blue);

    }

    private static void check(int x, int y, int n) {
        for (int i = x; i < n + x; i++) {
            for (int j = y; j < n + y; j++) {
                if (paper[i][j] != paper[x][y]) {
                    int size = n/2;
                    check(x, y, size);
                    check(x + size, y, size);
                    check(x, y + size, size);
                    check(x + size, y + size, size);
                    return;
                }
            }
        }

        if(paper[x][y] == 0) white++;
        else blue++;

    }

}

// 참고 : https://www.acmicpc.net/problem/2630