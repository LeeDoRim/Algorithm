package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2146_다리_만들기 {

	static int N, islandCnt = 1, result = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visit;

	static Queue<Node> queue = new ArrayDeque<>();
	
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
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 번호 붙이기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 1 || visit[i][j]) continue;
				islandCnt++;
				islandNumbering(i, j);
			}
		}
		
		// 섬을 잇는 가장 짧은 다리 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue;
				result = Math.min(minDistance(i, j, map[i][j]), result);
			}
		}
		
		System.out.println(result);

	}
	
	// 섬 번호 붙이기
	static void islandNumbering(int y, int x) {
		visit[y][x] = true;
		map[y][x] = islandCnt;
		queue.offer(new Node(y, x));
		
		while ( !queue.isEmpty() ) {
			Node node = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				
				if( ny < 0 || nx < 0 || ny >= N || nx >= N ) continue;
				if( map[ny][nx] != 1 || visit[ny][nx] ) continue;
				
				visit[ny][nx] = true;
				map[ny][nx] = islandCnt;
				queue.offer(new Node(ny, nx));
			}
			
		}
		
	}

	// 섬을 잇는 가장 짧은 다리 찾기
	static int minDistance(int y, int x, int islandNumber) {
		Queue<Node> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N]; 

		queue.offer(new Node(y, x));
		visited[y][x] = true;

		int distance = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			// 현재 레벨의 모든 노드를 탐색
			for (int i = 0; i < size; i++) {
				Node current = queue.poll();

				for (int d = 0; d < 4; d++) {
					int ny = current.y + dy[d];
					int nx = current.x + dx[d];

					// 범위를 벗어나거나 방문한 적이 있으면 건너뜀
					if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
					if (visited[ny][nx]) continue;

					// 다른 섬에 도달했으면 현재 거리를 반환
					if (map[ny][nx] != 0 && map[ny][nx] != islandNumber) return distance;


					// 바다를 탐색 중인 경우에만 큐에 추가
					if (map[ny][nx] == 0) {
						visited[ny][nx] = true;
						queue.offer(new Node(ny, nx));
					}
				}
			}
			distance++; // BFS의 레벨이 깊어질수록 거리를 증가
		}

		// 만약 다른 섬에 도달하지 못했으면 최댓값 반환
		return Integer.MAX_VALUE;
	}

}
