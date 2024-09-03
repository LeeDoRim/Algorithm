package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_8911_거북이 {

	static int testCaseNumber, minX, maxX, minY, maxY;
	static String move;
	static int[] turtle = new int[3]; // 거북이 위치 : x, y, d
	static int[] direction = {0, 1, 2, 3}; // 북, 동, 남, 서
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCaseNumber = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCaseNumber; i++) { // 테스트케이스 수만큼 반복
			move = br.readLine();
			turtle[0] = 0; turtle[1] = 0; turtle[2] = 0;
			minX = 0; maxX = 0; minY = 0; maxY = 0;
			
			for (int j = 0; j < move.length(); j++) { // 거북이 이동 횟수만큼 반복
				switch (move.charAt(j)) {
				case 'F':
					switch (turtle[2]) { 
					case 0: // 북
						if(++turtle[1] > maxY) maxY = turtle[1]; break;
					case 1: // 동
						if(++turtle[0] > maxX) maxX = turtle[0]; break;
					case 2: // 남
						if(--turtle[1] < minY) minY = turtle[1]; break;
					case 3: // 서
						if(--turtle[0] < minX) minX = turtle[0]; break;
					}
					break;
				case 'B':
					switch (turtle[2]) { 
					case 0: // 북
						if(--turtle[1] < minY) minY = turtle[1]; break;
					case 1: // 동
						if(--turtle[0] < minX) minX = turtle[0]; break;
					case 2: // 남
						if(++turtle[1] > maxY) maxY = turtle[1]; break;
					case 3: // 서
						if(++turtle[0] > maxX) maxX = turtle[0]; break;
					}
					break;
				case 'R': turtle[2] = (turtle[2] + 1 + 4) % 4; break;
				case 'L': turtle[2] = (turtle[2] - 1 + 4) % 4; break;
				}
				
			} // 거북이 이동 완료
			
			int nx = Math.abs(maxX - minX);
			int ny = Math.abs(maxY - minY);
			System.out.println(nx * ny);
			
		} 
		
	}
	
}
