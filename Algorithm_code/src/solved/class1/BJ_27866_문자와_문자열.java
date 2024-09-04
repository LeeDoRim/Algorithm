package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_27866_문자와_문자열 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int i = Integer.parseInt(br.readLine());
		
		System.out.println(str.charAt(i-1));
		
	}

}
