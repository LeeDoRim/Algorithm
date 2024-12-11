package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_1269_대칭_차집합 {

    static int ACount, BCount;
    static Set<Integer> A = new HashSet<>();
    static Set<Integer> B = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ACount = Integer.parseInt(st.nextToken());
        BCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < ACount; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < BCount; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> copy = new HashSet<>(A);

        A.removeAll(B);
        B.removeAll(copy);
        A.addAll(B);

        System.out.println(A.size());

    }

}

// 참고 : https://velog.io/@tlsdmsgp33/%EB%B0%B1%EC%A4%80-1269%EB%B2%88-%EB%8C%80%EC%B9%AD-%EC%B0%A8%EC%A7%91%ED%95%A9-java-%ED%92%80%EC%9D%B4
