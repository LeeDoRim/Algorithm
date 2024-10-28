package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13335_트럭 {

    static int N, W, L, weightOnBridge = 0, result = 0; // N : 다리를 건너는 트럭의 수, W : 다리의 길이, L : 다리의 최대하중
    static Queue<Integer> trucks = new LinkedList<>();
    static Queue<Integer> bridge = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trucks.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        while( !bridge.isEmpty() ) {
            result++;
            weightOnBridge -= bridge.poll();

            if(trucks.isEmpty()) continue; // 트럭이 비어있으면 건너뛰기

            if( trucks.peek() + weightOnBridge <= L ) { // 다리 위를 트럭이 지나갈 수 있는 경우
                int truck = trucks.poll();
                weightOnBridge += truck;
                bridge.offer(truck);
            } else { // 트럭이 지나갈 수 없는 경우
                bridge.offer(0);
            }

        }

        System.out.println(result);

    }

}

// 참고 : https://velog.io/@guswlsdl0121/%EB%B0%B1%EC%A4%80-13335%EB%B2%88-%ED%8A%B8%EB%9F%AD-with-Java