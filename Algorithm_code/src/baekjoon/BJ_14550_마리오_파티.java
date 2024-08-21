package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14550_마리오_파티 {
	
	static int N, S, T;
	static int[] map;
	static int[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = 1;
		
		while(true) { // 테스트케이스 반복 start
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 출발점과 별 사이의 칸 수
			if( N == 0 && !(st.hasMoreTokens()) ) break; // 테스트 케이스 끝(0)인 경우 종료
			
			S = Integer.parseInt(st.nextToken()); // 1 ~ S 사이의 자연수 주사위
			T = Integer.parseInt(st.nextToken()); // T턴이 지나면 게임 종료
			
			map = new int[N+2]; // N + 2 : 시작, 도착 포함
			dp = new int[T][N+2]; // int[턴수][보드]
			
			for (int i = 0; i < T; i++) { // dp배열 초기화
				Arrays.fill(dp[i], Integer.MIN_VALUE);
				dp[i][0] = 0; // 각 턴의 시작점 0으로 초기화
			}
			
			// map 입력
			int cnt = 1;
			while(cnt < N+1) { // cnt 범위 : 1 ~ N+1
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					map[cnt] = Integer.parseInt(st.nextToken());
					cnt++;
				}
			}
			
			if (S >= 0) System.arraycopy(map, 1, dp[0], 1, S); // 1회 턴 초기화 (map[0][])
			
			for (int i = 1; i < T; i++) {  // 턴 수 (2회 ~ T회)
				for (int j = 1; j < N+2; j++) { // 1 ~ N+1 보드
					for (int k = 1; k <= S; k++) { // 각 칸에서 움직일 수 있는 자연수
						if(j-k>=0 && dp[i-1][j-k] != Integer.MIN_VALUE){ // 이전 턴에서 이동 가능하면
                            				dp[i][j] = Integer.max( dp[i][j], dp[i-1][j-k]+map[j] );
                        			}
					}
				}
			}
			
			System.out.println(dp[T-1][N+1]);
			
		} // 테스트케이스 반복 end
		
	}

}

// 참고 : https://begong313.tistory.com/46
