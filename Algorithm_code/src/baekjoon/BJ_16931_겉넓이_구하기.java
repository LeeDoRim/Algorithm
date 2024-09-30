package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16931_겉넓이_구하기 {
	
	static int N, M, result = 0;
	static int[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result += N * M * 2; // 윗면, 아랫면
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int count = map[i][j] * 4; // 옆면
				
				for (int d = 0; d < 4; d++) {
					int ny = i + dy[d];
					int nx = j + dx[d];
					
					if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
					
					// 겹치는 옆면 제외
					if(map[ny][nx] > map[i][j]) count -= map[i][j]; 
					else count -= map[ny][nx];
					
				}
				
				result += count;
			}
		}
		
		System.out.println(result);
	}

}

// 참고 : https://velog.io/@hyeon930/BOJ-16931-%EA%B2%89%EB%84%93%EC%9D%B4-%EA%B5%AC%ED%95%98%EA%B8%B0-Java