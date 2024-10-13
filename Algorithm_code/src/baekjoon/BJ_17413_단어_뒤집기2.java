package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_17413_단어_뒤집기2 {

    static boolean flag = false;
    static int start = -1, end = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '<') {
                    if(start != -1) {
                        for (int j = i-1; j >= start; j--) {
                            if(str.charAt(j) == '>') continue;
                            System.out.print(str.charAt(j));
                        }
                        start = -1;
                    }
                    flag = true;
                }

                if(flag) System.out.print(str.charAt(i));

                if (str.charAt(i) == '>') flag = false;


                if( start == -1 && !flag && str.charAt(i) != '<' ) start = i;

                if( (!flag && start != -1 && str.charAt(i) == ' ') || (i == str.length()-1) ) {
                    if(i == str.length()-1) end = i;
                    else end = i-1;

                    for (int j = end; j >= start; j--) {
                            if(str.charAt(j) == '>') continue;
                            System.out.print(str.charAt(j));
                        }
                        System.out.print(' ');
                        start = -1;
                }

            }

            System.out.print(" ");
    }

}
