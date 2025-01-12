package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4153_직각삼각형_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0) break;

            if(a > c) {
                int temp = c;
                c = a;
                a = temp;
            }

            if(b > c) {
                int temp = c;
                c = b;
                b = temp;
            }

            if(a * a + b * b == c * c) System.out.println("right");
            else System.out.println("wrong");
        }

    }

}
