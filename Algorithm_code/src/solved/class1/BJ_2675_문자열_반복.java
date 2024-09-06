package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2675_문자열_반복 {
	
	static int T, R;
	static String str;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			str = st.nextToken();
			
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				for (int k = 0; k < R; k++) {
					System.out.print(c);
				}
			}
			
			System.out.println();
		}
		
	}

}
