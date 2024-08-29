package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12891_DNA_비밀번호 {
	
	static int S, P, minA, minC, minG, minT, result = 0;
	static String DNA;
	static int[] count = new int[4];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
		P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
		DNA = br.readLine(); // DNA 문자열
		
		st = new StringTokenizer(br.readLine());
		minA = Integer.parseInt(st.nextToken()); // A의 최소 개수
		minC = Integer.parseInt(st.nextToken()); // C의 최소 개수
		minG = Integer.parseInt(st.nextToken()); // G의 최소 개수
		minT = Integer.parseInt(st.nextToken()); // T의 최소 개수
		
		// 첫 번째 부분 문자열 알파벳 카운트
		for (int i = 0; i < P; i++) {
			switch ( DNA.charAt(i) ) {
			case 'A' : count[0]++; break;
			case 'C' : count[1]++; break;
			case 'G' : count[2]++; break;
			case 'T' : count[3]++; break;
			}
		}
		
		// 부분 문자열 비밀번호 적합성 확인
		if( count[0] >= minA && count[1] >= minC && count[2] >= minG && count[3] >= minT ) {
			result++;
		}
		
		for (int i = P; i < S; i++) {
			// 맨 앞 문자 제거
			switch( DNA.charAt(i-P) ) {
			case 'A' : count[0]--; break;
			case 'C' : count[1]--; break;
			case 'G' : count[2]--; break;
			case 'T' : count[3]--; break;
			}
			
			// 맨 두 문자 제거
			switch( DNA.charAt(i) ) {
			case 'A' : count[0]++; break;
			case 'C' : count[1]++; break;
			case 'G' : count[2]++; break;
			case 'T' : count[3]++; break;
			}
			
			// 부분 문자열 비밀번호 적합성 확인
			if( count[0] >= minA && count[1] >= minC && count[2] >= minG && count[3] >= minT ) {
				result++;
			}
		}
		
		// 만들 수 있는 비밀번호 종류의 수 출력
		System.out.println(result);
		
	}

}

// 참고 : https://jjw7.tistory.com/45
