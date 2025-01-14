package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_1259_팰린드롬수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int num = Integer.parseInt(br.readLine());
            int[] numbers = new int[5];
            int index = 0;
            boolean flag = true;

            if (num == 0) break;

            while (num != 0) {
                numbers[index++] = num % 10;
                num /= 10;
            }

            for (int i = 0; i < index/2; i++) {
                if (numbers[i] != numbers[index - 1 - i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) System.out.println("yes");
            else System.out.println("no");
        }

    }

}
