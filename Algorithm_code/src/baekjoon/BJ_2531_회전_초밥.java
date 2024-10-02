package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2531_회전_초밥 {
	
	static int N, d, k, c, count = 0, result = 0;
	static int[] type, check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		type = new int[N];
		check = new int[d+1];
		
		for (int i = 0; i < N; i++) {
			type[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < k; i++) {
			if(check[type[i]] == 0) count++;
			check[type[i]]++;
		}
		
		for (int i = 0; i < N; i++) {
			if(check[c] == 0) result = Math.max(result, count+1);
			else result = Math.max(result, count);
			
			check[type[i]]--;
			if(check[type[i]] == 0) count--;
			if(check[type[(i+k)%N]] == 0) count++;
			check[type[(i+k)%N]]++;
		}
		
		System.out.println(result);
		
	}
	
}

// 참고 : https://develop247.tistory.com/595