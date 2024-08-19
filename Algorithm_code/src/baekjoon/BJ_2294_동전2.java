package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2294_동전2 {

	static int N, K;
	static int[] coinType;
	static int[] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coinType = new int[N];
		result = new int[K+1];
		Arrays.fill(result, 100001);
		result[0] = 0;
		
		for (int i = 0; i < N; i++) {
			coinType[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
            for (int j = coinType[i]; j <= K; j++) {
            	result[j] = Math.min(result[j], result[j - coinType[i]] + 1);
            }
        }

        if (result[K] == 100001) {
        	result[K] = -1;
        }
        
        System.out.println(result[K]);
		
	}

}

// 참고 : https://olrlobt.tistory.com/32
