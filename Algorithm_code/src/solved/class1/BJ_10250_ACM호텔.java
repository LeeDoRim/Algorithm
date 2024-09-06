package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10250_ACM호텔 {

	static int T, H, W, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < W; j++) {  // 호실
				for (int k = 0; k < H; k++) { // 층
					N--;
					if(N == 0) {
						System.out.printf("%d%02d\n", k+1, j+1);
						break;
					}
				}
			}
			
		}
		
	}
	
}
