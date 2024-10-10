package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1531_투명 {
	
	static int N, M, result = 0;
	static int[][] map = new int[100][100];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			
			for (int j = y1; j <= y2; j++) {
				for (int k = x1; k <= x2; k++) {
					map[j][k]++;
				}
			}
			
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] > M) result++;
			}
		}
		
		System.out.println(result);
	}
	
}

// 참고 : https://velog.io/@hurryduck/%EB%B0%B1%EC%A4%80-1531%EB%B2%88-%ED%88%AC%EB%AA%85-Java