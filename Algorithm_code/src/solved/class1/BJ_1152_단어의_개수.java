package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1152_단어의_개수 {
	
	static int count;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while ( st.hasMoreTokens() ) {
			st.nextToken();
			count++;
		}
		
		System.out.println(count);
		
	}

}
