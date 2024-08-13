package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1788_피보나치_수의_확장 {

	static int N, result;
	static int[] memory;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		memory = new int[Math.abs(N) + 2];

		memory[0] = 0;
		memory[1] = 1;

		// 피보나치 수열
		for (int i = 2; i <= Math.abs(N); i++) {
			memory[i] = (memory[i - 1] + memory[i - 2]) % 1000000000;
		}

		if (N < 0 && N % 2 == 0) {
			// N이 음수이고 짝수일 때
			result = -memory[-N];
		} else {
			// 그 외의 경우
			result = memory[Math.abs(N)];
		}

		if (result > 0) {
			System.out.println(1);
		} else if (result < 0) {
			System.out.println(-1);
		} else {
			System.out.println(0);
		}

		System.out.println(Math.abs(result));

	}

}
