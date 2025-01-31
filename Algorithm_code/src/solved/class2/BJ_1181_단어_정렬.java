package solved.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class BJ_1181_단어_정렬 {

    static int N;
    static LinkedHashSet[] words;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new LinkedHashSet[51];

        for (int i = 1; i < 51; i++) {
            words[i] = new LinkedHashSet<String>();
        }

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[word.length()].add(word);
        }

        for (int i = 1; i < 51; i++) {
            words[i].stream().sorted().forEach(System.out::println);
        }

    }

}
