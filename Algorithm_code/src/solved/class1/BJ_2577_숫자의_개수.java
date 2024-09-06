package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2577_숫자의_개수 {

	static int A, B, C;
	static int[] number = new int[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		
		int multi = A * B * C;
		
		while( multi != 0 ) {
			switch (multi%10) {
			case 0: number[0]++; break;
			case 1: number[1]++; break;
			case 2: number[2]++; break;
			case 3: number[3]++; break;
			case 4: number[4]++; break;
			case 5: number[5]++; break;
			case 6: number[6]++; break;
			case 7: number[7]++; break;
			case 8: number[8]++; break;
			case 9: number[9]++; break;
			}
			multi /= 10;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(number[i]);
		}
		
	}
	
}
