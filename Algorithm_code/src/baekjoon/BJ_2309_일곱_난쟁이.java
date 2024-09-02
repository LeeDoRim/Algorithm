package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱_난쟁이 {
	
	static int sum = 0;
	static int[] height = new int[9];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if(sum - height[i] - height[j] == 100) {
					height[i] = 0;
					height[j] = 0;
					Arrays.sort(height);
					for (int k = 2; k < 9; k++) {
						System.out.println(height[k]);
					}
					return;
				}
				
			}
		}
		
	}
	
}

// 참고 : https://gongrogramming.tistory.com/m/83