package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_4848_집합_숫자_표기법 {
	
	static int N;
	static String[] numbers = new String[16];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		numbers[0] = "{}";
		numbers[1] = "{{}}";
		numbers[2] = "{{},{{}}}";
		numbers[3] = "{{},{{}},{{},{{}}}}";
		numbers[4] = "{{},{{}},{{},{{}}},{{},{{}},{{},{{}}}}}";
		
		for (int i = 5; i < 16; i++) {
			String str = numbers[i-1].substring(1, numbers[i-1].length()-1);
			numbers[i] = "{" + str + "," + numbers[i-1] + "}"; 
		}
		
		// 더하기
		for (int i = 0; i < N; i++) {
			String str1 = br.readLine();
			String str2 = br.readLine();
			int index1 = 0, index2 = 0;
			
			for (int j = 0; j < 16; j++) {
				if(numbers[j].equals(str1)) {
					index1 = j;
					break;
				}
			}
			
			for (int j = 0; j < 16; j++) {
				if(numbers[j].equals(str2)) {
					index2 = j;
					break;
				}
			}
			
			System.out.println(numbers[index1 + index2]);
			
		}
		
	}

}
