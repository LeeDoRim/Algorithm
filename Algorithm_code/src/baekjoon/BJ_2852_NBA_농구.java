package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2852_NBA_농구 {

    static int N, aTeam = 0, bTeam = 0, aScore = 0, bScore = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        String prev = "00:00";

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int winTeam = Integer.parseInt(st.nextToken());
            String winTime = st.nextToken();

            if (aTeam > bTeam) {
                aScore += changeMinuteToSecond(winTime) - changeMinuteToSecond(prev);
            } else if (bTeam > aTeam) {
                bScore += changeMinuteToSecond(winTime) - changeMinuteToSecond(prev);
            }

            if (winTeam == 1) aTeam++;
            else bTeam++;

            prev = winTime;
        }

        if (aTeam > bTeam) {
            aScore += changeMinuteToSecond("48:00") - changeMinuteToSecond(prev);
        } else if (bTeam > aTeam) {
            bScore += changeMinuteToSecond("48:00") - changeMinuteToSecond(prev);
        }

        System.out.printf("%02d:%02d\n", aScore/60, aScore%60);
        System.out.printf("%02d:%02d\n", bScore/60, bScore%60);

    }

    public static int changeMinuteToSecond(String time) { // 단위를 하나로 해준다.
        int minute = Integer.parseInt(time.substring(0, 2));
        int second = Integer.parseInt(time.substring(3, 5));

        return minute * 60 + second;
    }

}

// 참고 : https://roughroad.tistory.com/m/463