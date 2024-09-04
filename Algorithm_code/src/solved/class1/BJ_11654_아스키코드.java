package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_11654_아스키코드 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char ascii = br.readLine().charAt(0);
		
		System.out.println((int) ascii);
	}

}
