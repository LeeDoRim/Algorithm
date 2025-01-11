package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_15829_Hashing {

    static int N;
    static long mod = 1, result = 0;
    static char[] string, arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        string = new char[N];
        arr = new char[26];

        for (int i = 0; i < 26; i++) {
            arr[i] = (char) (i + 97);
        }

        string = br.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 26; j++) {
                if (string[i] == arr[j]) {
                    result +=  (j + 1) * mod;
                    mod = (31 * mod) % 1234567891;
                    break;
                }
            }
        }

        System.out.println(result % 1234567891);
    }

}

// 참고 : https://cocoiscat.tistory.com/91