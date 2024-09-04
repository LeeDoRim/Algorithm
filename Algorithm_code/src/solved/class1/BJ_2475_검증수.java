package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2475_검증수 {
	
	static int[] serialNumber = new int[5];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		
		for (int i = 0; i < 5; i++) {
			serialNumber[i] = Integer.parseInt(st.nextToken());
			serialNumber[i] *= serialNumber[i];
			sum += serialNumber[i];
		}
		
		System.out.println(sum%10);
		
	}

}
