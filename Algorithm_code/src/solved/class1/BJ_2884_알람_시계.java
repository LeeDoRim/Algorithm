package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2884_알람_시계 {
	
	static int H, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		M -= 45;
		
		if( M < 0 ) {
			H -= 1;
			M += 60;
		}
		
		if(H < 0) H += 24;
		
		System.out.println( H + " " + M);
		
	}

}
