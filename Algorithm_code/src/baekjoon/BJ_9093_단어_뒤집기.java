package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9093_단어_뒤집기 {

    static int T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                String reverse = "";
                for (int j = str.length()-1; j >= 0; j--) {
                    reverse += str.charAt(j);
                }
                System.out.print(reverse + " ");
            }
            System.out.println();
        }

    }

}