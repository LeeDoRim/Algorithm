package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_도영이가_만든_맛있는_음식 {
	
	static int N, min;
	static int[][] src;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		src = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		
		dfs(0, 1, 0);
		
		System.out.println(min);
		
	}
	
	static void dfs(int srcIndex, int sinSum, int ssnSum) {
		if( srcIndex == N) return;
		
		int currSin = src[srcIndex][0] * sinSum;
		int currSsn = src[srcIndex][1] + ssnSum;
		
		min = Math.min(min, Math.abs(currSin - currSsn));
		
		dfs(srcIndex + 1, currSin, currSsn);
		dfs(srcIndex + 1, sinSum, ssnSum);
	}
	
}
