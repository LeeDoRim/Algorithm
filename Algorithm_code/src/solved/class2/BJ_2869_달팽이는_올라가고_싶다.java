package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869_달팽이는_올라가고_싶다 {

    static int A, B, V, m = 0, day = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        m = V - B;
        day += m / (A - B);
        if (m % (A - B) != 0) day++;

        System.out.println(day);
    }

}
