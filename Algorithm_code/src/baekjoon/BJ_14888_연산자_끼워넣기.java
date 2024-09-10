package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888_연산자_끼워넣기 {
	
	static int N, maxResult = Integer.MIN_VALUE, minResult = Integer.MAX_VALUE;
	static int[] number, operator;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		number = new int[N];
		operator = new int[4]; // 덧셈, 뺄셈, 곱셈, 나눗셈
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최솟값, 최댓값 구하기
		solution(number[0], 1);
		
		System.out.println(maxResult);
		System.out.println(minResult);
		
	}
	
	static void solution(int num, int index) { // 백트래킹
		
		if(index == N) {
			maxResult = Math.max(maxResult, num);
			minResult = Math.min(minResult, num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(operator[i] > 0) {  // 연산자 개수가 1 이상인 경우
				operator[i]--;
				
				switch (i) {
				case 0: solution(num + number[index], index + 1); break;
				case 1: solution(num - number[index], index + 1); break;
				case 2: solution(num * number[index], index + 1); break;
				case 3: solution(num / number[index], index + 1); break;
				}
				
				operator[i]++; // 재귀호출이 종료되면 다시 연산자 개수 증가
			}
		}
		
	}

}

// 참고 : https://velog.io/@gayeong39/%EB%B0%B1%EC%A4%80-14888-%EC%97%B0%EC%82%B0%EC%9E%90-%EB%81%BC%EC%9B%8C%EB%84%A3%EA%B8%B0-JAVA
