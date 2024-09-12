package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11729_하노이_탑_이동_순서 {
	
	static int N, moveCnt = 0;
	static StringBuilder sb = new StringBuilder();
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		move(N, 1, 2, 3);
		
		System.out.println(moveCnt);
		System.out.println(sb);
		
	}
	
	static void move(int number, int start, int middle, int end) {
		if(number == 0) return;
		moveCnt++;
		
		move(number-1, start, end, middle);
		sb.append(start + " " + end + "\n");
		move(number-1, middle, start, end);
	}
	
}

// 참고
// 하노이의 탑 : https://hojunking.tistory.com/123
// 시간초과 해결 : https://hoehen-flug.tistory.com/43