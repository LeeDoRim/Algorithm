package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2439_별_찍기_2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			for (int j = N; j >= 1; j--) {
				if(j > i) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
