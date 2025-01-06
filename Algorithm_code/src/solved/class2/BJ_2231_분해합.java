package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2231_분해합 {

    static int N, result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            int sum = 0;
            int number = i;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum + i == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);

    }

}

// 참고 : https://kkungchan.tistory.com/332