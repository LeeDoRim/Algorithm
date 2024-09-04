package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2753_윤년 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int YEAR = Integer.parseInt(br.readLine());
		
		if( (YEAR%4 == 0 && YEAR%100 != 0) || YEAR%400 == 0 ) System.out.println(1);
		else System.out.println(0);
		
	}

}
