package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2562_최댓값 {
	
	static int index, maxValue = 0;
	static int[] number = new int[9];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			number[i] = Integer.parseInt(br.readLine());
			if(maxValue < number[i]) {
				index = i+1;
				maxValue = number[i];
			}
		}
		
		System.out.println(maxValue);
		System.out.println(index);
		
	}

}
