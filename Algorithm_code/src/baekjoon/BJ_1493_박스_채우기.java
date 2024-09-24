package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1493_박스_채우기 {
	
	static int length, width, height, N, result = 0;
	static boolean flag = true;
	static int[] cube = new int[20];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		length = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
        	cube[idx] = Integer.parseInt(st.nextToken());
		}
	
		box(length, width, height);
		
		if(flag) System.out.println(result);
		else System.out.println(-1);
		
	}
	
	static void box(int length, int width, int height) {
		
		if (length == 0 || width == 0 || height == 0) return;

		int cubeSide = 0;
		
		for(int i=19;i>=0;i--) { //큐브 큰것 부터 찾음 
			
			flag = false;
			
			cubeSide=1<<i;//2^i
			
            //해당 큐브의 변이 채워야하는 상자의 길이보다 작으며, 개수가 0보다 많아야한다
			if( cubeSide <= length && cubeSide <= width && cubeSide <= height && cube[i] > 0 ) {
				//만약 넣었으면 해당 큐브 개수 1감소, count 1 증가, state = true
				cube[i]--;
				result++;
				flag = true;
				break;
			}
		}
		
		if(!flag) return; //state가 false이면 박스안에 넣을 큐브가 더이상 없다는 것이므로 리턴 
		
		//박스를 자르면 남는 세개의 박스에 대해 호춣한다.
		box(length-cubeSide, cubeSide, cubeSide);
		box(length, width-cubeSide, cubeSide);
		box(length, width, height-cubeSide);
		
	}

}

// 참고 : https://jackine.tistory.com/4
