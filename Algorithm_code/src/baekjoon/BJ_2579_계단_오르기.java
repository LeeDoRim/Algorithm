package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2579_계단_오르기 {

	static int N;
	static int[] step, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		step = new int[N+1];
		dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = step[1];
		if(N >= 2) dp[2] = step[1] + step[2];
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+step[i-1]) + step[i]; // 한칸 전 또는 두칸 전 계단 중 큰 값 선택
		}
		
		System.out.println(dp[N]);
	}
	
}

// 참고 : https://kimtaesoo99.tistory.com/31