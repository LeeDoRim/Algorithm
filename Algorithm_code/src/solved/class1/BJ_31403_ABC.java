package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_31403_ABC {
	
	static int A, B, C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = Integer.parseInt(br.readLine());
		B = Integer.parseInt(br.readLine());
		C = Integer.parseInt(br.readLine());
		
		System.out.println( A + B - C );
		String ab =  "" + A + B;
		System.out.println( Integer.parseInt(ab) - C );
	}
	
}

// 참고 : https://velog.io/@jhj99/%EB%B0%B1%EC%A4%80-31403%EB%B2%88-A-B-C