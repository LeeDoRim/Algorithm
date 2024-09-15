package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1021_회전하는_큐 {

	static int N, M, result = 0;
	static int[] deleteNumber;
	static LinkedList<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		deleteNumber = new int[M];
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			deleteNumber[i] = Integer.parseInt(st.nextToken());
		}
		
		delete(M);
		
		System.out.println(result);
		
	}
	
	static void delete(int m) {
		for (int i = 0; i < M; i++) {
			
			int targetIndex = queue.indexOf(deleteNumber[i]); // 찾으려는 숫자
			int middleIndex;
			
			if(queue.size() % 2 == 0) {
				middleIndex = queue.size() / 2 - 1; // 인덱스 시작이 0부터 이므로 -1
			} else {
				middleIndex = queue.size() / 2;
			}
			
			if(targetIndex <= middleIndex) { // targetIndex가 중간보다 앞에 있는 경우
				for (int j = 0; j < targetIndex; j++) { // 왼족으로 이동
					int temp = queue.pollFirst();
					queue.offerLast(temp);
					result++;
				}
			} else { // targetIndex가 중간보다 뒤에 있는 경우
				for (int j = 0; j < queue.size() - targetIndex; j++) { // 오른쪽으로 이동
					int temp = queue.pollLast();
					queue.offerFirst(temp);
					result++;
				}
			}
			
			queue.pollFirst(); // targetIndex 제거
		}
		
	}
	
}

// 참고 : https://velog.io/@gayeong39/%EB%B0%B1%EC%A4%80-1021-%ED%9A%8C%EC%A0%84%ED%95%98%EB%8A%94-%ED%81%90-JAVA
