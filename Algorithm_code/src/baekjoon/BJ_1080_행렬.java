package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1080_행렬 {

    static int N, M, result = 0;
    static char[][] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][M];
        B = new char[N][M];

        for (int i = 0; i < N; i++) {
            A[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            B[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if(A[i][j] != B[i][j]) {
                    result++;
                    if(N < 3 || M < 3) continue;
                    for (int k = i; k < i+3; k++) {
                        for (int l = j; l < j+3; l++) {
                            if(A[k][l] == '0') A[k][l] = '1';
                            else A[k][l] = '0';
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result);

    }

}

// 참고 : https://cse-gr.tistory.com/108
