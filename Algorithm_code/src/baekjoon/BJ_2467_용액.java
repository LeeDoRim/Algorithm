package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2467_용액 {
	
	static int N, min = Integer.MAX_VALUE;
	static int solution1 = 0, solution2 = 0;
	static int[] quality;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		quality = new int[N];
		int left = 0, right = N-1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			quality[i] = Integer.parseInt(st.nextToken());
		}
		
		while(left< right) {
			int sum = quality[left] + quality[right];
			if(min >= Math.abs(sum)) {
				min = Math.abs(sum);
				solution1 = quality[left]; solution2 = quality[right];
			}
			
			if(sum >= 0) right--;
			else left++;
		}
		
		System.out.println(solution1 + " " + solution2);
		
	}

}

// 참고 : https://loosie.tistory.com/559