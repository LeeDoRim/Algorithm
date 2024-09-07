package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_3052_나머지 {
	
	static int result = 1;
	static int[] number = new int[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i++) {
			number[i] = Integer.parseInt(br.readLine()) % 42;
		}
		
		Arrays.sort(number);
		
		for (int i = 1; i < 10; i++) {
			if(number[i-1] != number[i]) result++;
		}
		
		System.out.println(result);
	}

}
