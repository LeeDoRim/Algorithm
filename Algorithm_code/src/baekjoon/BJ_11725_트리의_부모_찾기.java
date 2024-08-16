package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11725_트리의_부모_찾기 {

	static int N;
	static int[] node;  // 부모노드 저장
	static boolean[] visit; // 방문 여부
	static ArrayList<Integer>[] list; // 노드 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		node = new int[N+1];
		visit = new boolean[N+1];
		list = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < (N-1); i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		dfs(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(node[i]);
		}
		
	}
	
	public static void dfs(int index) {
		visit[index] = true;
		for (int i : list[index]) {
			if(!visit[i]) {
				node[i] = index;
				dfs(i);
			}
		}
	}
	
}

// 참고 : https://codesign.tistory.com/122

// 시간 초과
/*
public class BJ_11725_트리의_부모_찾기 {

	static int N, levelCnt = 0;
	static int[] node, level;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		node = new int[N+1];
		level = new int[N+1];
		Arrays.fill(level, Integer.MAX_VALUE);
		level[1] = 0;
		
		for (int i = 0; i < (N-1); i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			if(level[n1] > level[n2]) {
				int temp = n1;
				n1 = n2;
				n2 = temp;
			}

			node[n2] = n1;
			// 같은 노드를 부모로 갖는 노드가 있으면 같은 level
			for (int j = 2; j <= N; j++) {
				if (node[n2] == node[i])
					level[n2] = level[i];
			}
			// 없으면 level 증가
			if (level[n2] == Integer.MAX_VALUE) {
				level[n2] = levelCnt + 1;
				levelCnt++;
			}

		}

		for (int i = 2; i <= N; i++) {
			System.out.println(node[i]);
		}
		
	}
	
}
*/