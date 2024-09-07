package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
	
	static int width, height, currTotalCheeseCnt = 0, time = 0;
	static int[][] board;
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static class Node {
		int y, x;
		Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		board = new int[height][width];
		
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < width; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) currTotalCheeseCnt++;
			}
		}
		
		int previousCheeseCnt = 0;
		while ( currTotalCheeseCnt != 0 ) {
			previousCheeseCnt = currTotalCheeseCnt;
			bfs();
			time++;
		}
		
		System.out.println(time);
		System.out.println(previousCheeseCnt);
		
	}
	
	static void bfs() {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[][] visit = new boolean[height][width]; 
		
		queue.offer(new Node(0, 0));
		visit[0][0] = true;
		
		while ( !queue.isEmpty() ) {
			Node node = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if( ny < 0 || nx < 0 || ny >= height || nx >= width || visit[ny][nx] ) continue;
				
				visit[ny][nx] = true;
				
				if( board[ny][nx] == 1 ) {
					board[ny][nx] = 0;
					currTotalCheeseCnt--;
				} else if ( board[ny][nx] == 0 ) {
					queue.add(new Node(ny, nx));
				}
				
			}
			
		}
		
	}

}

// 참고 : https://luz315.tistory.com/201
