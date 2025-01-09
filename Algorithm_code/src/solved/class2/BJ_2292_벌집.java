package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_2292_벌집 {

    static int N, result = 0, count = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (count <= N) {
            count += (result * 6);
            if (count >= N) break;
            result++;
        }

        System.out.println(result + 1);
    }

}
