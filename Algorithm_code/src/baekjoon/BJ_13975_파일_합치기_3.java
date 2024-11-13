package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ_13975_파일_합치기_3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(br.readLine());

        for(int i = 0; i < cases; i++) {
            int num = Integer.parseInt(br.readLine());

            Queue<Long> pq = new PriorityQueue<>();
            String[] data = br.readLine().split(" ");

            for(int j = 0; j < num; j++) {
                pq.offer(Long.parseLong(data[j]));
            }

            long total = 0;
            while(pq.size() > 1) {
                long num1 = pq.poll();
                long num2 = pq.poll();
                long sum = num1 + num2;

                total += sum;
                pq.offer(sum);
            }
            System.out.println(total);
        }

    }

}

// 참고 : https://happygimy97.tistory.com/m/210