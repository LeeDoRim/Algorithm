package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2920_음계 {
	
	static int ascending = 0, descending = 0, mixed = 0;
	static int[] number = new int[8];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		number[0] = Integer.parseInt(st.nextToken());		
		for (int i = 1; i < 8; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			if(number[i-1] + 1 == number[i]) ascending++;
			else if(number[i-1] - 1 == number[i]) descending++;
			else mixed++;
		}
		
		if(ascending == 7) System.out.println("ascending");
		else if(descending == 7) System.out.println("descending");
		else System.out.println("mixed");
		
	}
	
}
