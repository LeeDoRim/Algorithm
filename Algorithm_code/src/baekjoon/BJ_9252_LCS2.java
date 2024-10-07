package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9252_LCS2 {

	static String str1, str2;
	static int N, M;
	static int[][]dp;
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		N = str1.length();
		M = str2.length();
		dp = new int[N + 1][M + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[N][M]);
		
		while (N != 0 && M != 0 ) {
			if (str1.charAt(N-1) == str2.charAt(M-1)) {
				stack.push(str1.charAt(N-1));
				N--;
				M--;
			} else if(dp[N][M] == dp[N-1][M]) N--;
			else if(dp[N][M] == dp[N][M-1]) M--;
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
	}
	
}

// 참고 : https://subbak2.com/73