package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_4153_직각삼각형 {
	
	static int[] length = new int[3]; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while ( true ) {
			length[0] = Integer.parseInt(st.nextToken());
			length[1] = Integer.parseInt(st.nextToken());
			length[2] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(length);
			
			if(length[0] == 0 && length[1] == 0 && length[2] == 0) break;
			
			if( ((length[0]*length[0])+(length[1]*length[1])) == (length[2]*length[2]) ) System.out.println("right");
			else System.out.println("wrong");
			
			st = new StringTokenizer(br.readLine());
		}
	}

}
