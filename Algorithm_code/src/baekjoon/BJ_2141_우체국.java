package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_2141_우체국 {

    static int N, result = 0;
    static long sum, middle, idx = 0;
    static int[][] town;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        town = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            town[i][0] = a;
            town[i][1] = b;
            sum += b;
        }

        middle = (sum+1)/2;

        Arrays.sort(town, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            idx += town[i][1];
            if(idx >= middle){
                result = town[i][0];
                break;
            }
        }

        System.out.println(result);
    }

}

// 참고 : https://infinitecode.tistory.com/68