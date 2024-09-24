package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1992_쿼드트리 {
	
	static int N;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		divide(0, 0, N);
		System.out.println(sb);
		
	}
	
	static void divide(int y, int x, int n) {
		if( check(y, x, n) ) {
			sb.append(map[y][x]);
		} else {
			sb.append("(");
			int half = n/2;
			divide(y, x, half);
			divide(y, x + half, half);
			divide(y + half, x, half);
			divide(y + half, x + half, half);
			sb.append(")");
		}
	}
	
	static boolean check(int y, int x, int n) {
		char ch = map[y][x];
		
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if(ch != map[i][j]) return false;
			}
		}
		
		return true;
	}

}
