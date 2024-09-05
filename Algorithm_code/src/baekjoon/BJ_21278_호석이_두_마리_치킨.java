package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21278_호석이_두_마리_치킨 {
	
	static int N, M, store1, store2, totaltime = Integer.MAX_VALUE;
	static ArrayList<Integer>[] city;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		city = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			city[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			city[a].add(b);
			city[b].add(a);
		}
		
		int [] dis; // 각 건물에서 치킨 집까지 거리
		for (int i = 1; i <= N-1; i++) { // store1
			dis = new int[N+1];
            Arrays.fill(dis, Integer.MAX_VALUE);
			
			for (int j = 1+1; j <= N; j++) {  // store2
				dis[i] = dis[j] = 0;
				int sum = bfs(i, j, dis);
				
				if( totaltime > sum ) {
					totaltime = sum;
					store1 = i;
					store2 = j;
				}
			}
		}
		
		System.out.println(store1 + " " + store2 + " " + totaltime*2); // 왕복 거리 : totaltime*2
		
	}
	
	public static int bfs(int s1, int s2, int[] dis) {
		int sum = 0; // 총 거리 합
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(s1);
		queue.add(s2);
		visit[s1] = visit[s2] = true;
		
		while(! queue.isEmpty() ) {
			int v = queue.poll();
			
			// 현재 건물과 연결된 모든 건물 탐색
			for (int next : city[v]) {
				if( !visit[next] ) {
					queue.add(next);
					dis[next] = dis[v]+1; // 다음 건물의 거리는 현재 건물까지 거리 + 1
					sum += dis[next]; // 총 거리에 해당 건물까지의 거리를 더함
					visit[next] = true;
				}
			}
		}
		
		return sum; // 모든 건물에서 두 치킨 집까지의 최소 거리 합을 반환
	}
	
}

// 참고 : https://uzinlab.tistory.com/m/147
