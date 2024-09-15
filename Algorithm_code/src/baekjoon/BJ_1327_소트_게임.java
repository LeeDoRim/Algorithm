package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_1327_소트_게임 {
	
	static int N, K;
	static String number, answer;
	static ArrayList<Integer> list = new ArrayList<>();
	static Set<String> visited = new HashSet<>();
	
	static class Pair { // 순열, 뒤집은 횟수
		String s;
		int cnt;
		Pair(String s, int cnt) {
			this.s = s;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < N; i++) {
			sb.append(Integer.parseInt(st.nextToken()));
		}
		number = sb.toString(); // 입력받은 순열
		
		sb = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			sb.append(i);
		}
		answer = sb.toString(); // 오름차순 정렬된 순열
		
		// 정렬하기 위한 최소 선택 개수 구하기
		System.out.println(bfs(number));
	}
	
	public static int bfs(String number) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(number, 0));
		visited.add(number);
		
		while ( !queue.isEmpty() ) {
			Pair pair = queue.poll();
			if( pair.s.equals(answer) ) return pair.cnt; // 오름차순 정렬 시 선택 개수 반환
			
			for (int i = 0; i <= (N - K); i++) {  // 뒤집을 수 있는 수
				char[] charArr = pair.s.toCharArray();
				
				for (int j = 0; j < (K/2); j++) { // K번 뒤집기
					char temp = charArr[i + j];
					charArr[i + j] = charArr[i + K - 1 - j];
					charArr[i + K - 1 - j] = temp;
				}
				
				String n = new String(charArr);
				
				if( !visited.contains(n) ) {
					Pair tempPair = new Pair(n, pair.cnt + 1);
					queue.add(tempPair);
					visited.add(tempPair.s);
				}
			}
			
		}
		
		return -1;
	}

}

// 참고 : https://kau-algorithm.tistory.com/m/1563
