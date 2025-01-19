package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2609_최대공양수와_최소공배수 {

    static int min, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberA = Integer.parseInt(st.nextToken());
        int numberB = Integer.parseInt(st.nextToken());

        min = (Math.min(numberA, numberB));
        max = (Math.max(numberA, numberB));

        for (int i = min; i > 0; i--) {
            if (min % i == 0 && max % i == 0) {
                System.out.println(i);
                break;
            }
        }

        int countA = 1;
        int countB = 1;
        while (true) {
            if (numberA * countA == numberB * countB) {
                System.out.println(numberA * countA);
                break;
            }

            if (numberA * countA < numberB * countB) countA++;
            else countB++;
        }
    }

}
