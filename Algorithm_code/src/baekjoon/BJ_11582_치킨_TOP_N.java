package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11582_치킨_TOP_N {
	
	static int N, K;
	static int[] chickenHouse;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chickenHouse = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			chickenHouse[i] = Integer.parseInt(st.nextToken());
		}
		
		K = Integer.parseInt(br.readLine());
		
		for (int i = 2; i < N; i *= 2 ) {
			
			for (int j = 0; j < N ; j += i) {
				
				chickenHouseSort(j, j+i);
				
			}
			
			if( (N/i) == K ) break;
		}

		for (int i = 0; i < N; i++) {
			System.out.print(chickenHouse[i] + " ");
		}
		
		Arrays.toString(chickenHouse);
		
		
	}
	
	public static void chickenHouseSort(int start, int end) {
		int[] temp = new int[ (end - start) ];
		
		int idx = start;
		for (int i = 0; i < temp.length; i++) {
			temp[i] = chickenHouse[idx];
			idx++;
		}
		
		Arrays.sort(temp);
		
		idx = 0;
		for (int i = start ; i < end; i++) {
			chickenHouse[i] = temp[idx];
			idx++;
		}
		
	}
	
}
