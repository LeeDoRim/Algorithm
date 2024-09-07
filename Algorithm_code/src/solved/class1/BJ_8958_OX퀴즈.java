package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_8958_OX퀴즈 {
	
	static int testCnt;
	static String scores;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCnt = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCnt; i++) {
			scores = br.readLine();
			
			int train = 1, sum = 0;
			for (int j = 0; j < scores.length(); j++) {
				char score = scores.charAt(j);
				
				switch (score) {
				case 'O': sum += train; train++; break;
				case 'X': train = 1; break;
				}
			}
			
			System.out.println(sum);
			
		}
		
	}

}
