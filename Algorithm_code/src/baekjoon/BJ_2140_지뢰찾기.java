package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2140_지뢰찾기 {
	
	static int N, mineCount = 0;
	static char[][] map;
	static int[] dy = {-1, -1, -1,  0, 0,  1, 1, 1};
	static int[] dx = {-1,  0,  1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		// 지뢰찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(Character.isDigit(map[i][j])) { // 보드의 테두리(숫자 부분)만 지뢰 확인
					int cur = map[i][j] - '0';
					check(i, j, cur);
				}
			}
		}
		
		// 지뢰 갯수 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) { 
				if(map[i][j] == '*' || map[i][j] == '#') mineCount++;
			}
		}
		
		System.out.println(mineCount);
		
	}
	
	// 숫자인 부분의 8방향에 지뢰가 있는지 확인
	public static void check(int y, int x, int cur) {
		for (int i = 0; i < 8; i++) { 
			int ny = y + dy[i];
			int nx = x + dx[i];
			if( nx < 0 || ny < 0 || nx >= N || ny >= N ) continue; // 보드를 벗어난 경우
			
			if(map[ny][nx] == '#' && cur != 0) { // 지뢰 가능한 경우
				cur--;
				map[ny][nx] = '*';
			} else if(map[ny][nx] == '*' && cur != 0) { // 이미 지뢰인 경우
				cur--;
			} else if(map[ny][nx] == '#' && cur == 0) { // 지뢰를 넣을 수 없는 경우
				map[ny][nx] = '-';
			}
			
		}
		
	}

}

// 참고 : https://code-lab1.tistory.com/198
