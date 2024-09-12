package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2839_설탕_배달 {
	
	static int N;
	static int[] count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = new int[5001];
		Arrays.fill(count, -1);
		count[3] = 1;
		count[5] = 1;
		
		for (int i = 6; i <= N; i++) {
			int num1 = Integer.MAX_VALUE;
			int num2 = Integer.MAX_VALUE;
			if(count[i-3] != -1) num1 = count[i-3];
			if(count[i-5] != -1) num2 = count[i-5];
			if(num1 != Integer.MAX_VALUE || num2 != Integer.MAX_VALUE) {
				count[i] = Math.min(num1, num2) + 1;
			}
		}
		
		System.out.println(count[N]);
		
	}

}
