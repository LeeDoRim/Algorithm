package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_30802_웰컴_키트 {
	
	static int N, T, P, shirtCnt, penCnt;
	static int[] size = new int[6];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken()); 
		P = Integer.parseInt(st.nextToken());
		
		// 티셔츠 
		for (int i = 0; i < 6; i++) {
			shirtCnt += size[i]/T;
			if(size[i]%T != 0) shirtCnt++;
		}
		
		System.out.println(shirtCnt);
		System.out.println(N/P + " " + N%P);
		
	}

}
