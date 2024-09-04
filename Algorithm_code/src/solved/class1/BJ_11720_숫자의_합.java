package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11720_숫자의_합 {
	
	static int N, result = 0;
	static String str;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine();
		
		for (int i = 0; i < N; i++) {
			result += Character.getNumericValue(str.charAt(i));
		}
		
		System.out.println(result);
	}

}
