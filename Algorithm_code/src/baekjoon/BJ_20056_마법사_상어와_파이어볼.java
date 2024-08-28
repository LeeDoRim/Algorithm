package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_20056_마법사_상어와_파이어볼 {
	
	// 격자 크기 : N, 파이어볼 M 개, 질량 m, 방향 d, 속력 s, 위치 r행, c열, 이동 횟수 K
	static int N, M, K; // N : 격자 크기, M : 파이어볼 갯수, K : 이동 횟수
	static int[][][] map;
	static List<Fireball> fireballs = new ArrayList<>();
	
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	
	private static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;  // 행
            this.c = c;  // 열
            this.m = m;  // 질량
            this.s = s;  // 속력
            this.d = d;  // 방향
        }
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken()) -1;
			int c = Integer.parseInt(st.nextToken()) -1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			fireballs.add(new Fireball(r, c, m, s, d));
		}
		
		// 파이어볼
		while( K != 0 ) {
			int fireballCount = fireballs.size();
			map = new int[N][N][fireballCount];
			
			// 모든 파이어볼이 방향 d로 속력 s칸만큼 이동
			moveTheFireball(fireballs, fireballCount, map);
			
			// 중복된 위치의 파이어볼을 합치고 분해
			fireballs = splitTheFireball(fireballs, fireballCount, map);
			
			K--;
		}
		
		// 남아있는 파이어볼 질량의 합
		int result = 0;
		for (Fireball fireball : fireballs) {
			result += fireball.m;
        }
		
		System.out.println(result);
		
	}
	
	private static void moveTheFireball(List<Fireball> fireballs, int fireballCount, int[][][] map) {
        for (int i = 0; i < fireballs.size(); i++) {
            Fireball fireball = fireballs.get(i);

            int sy = dy[fireball.d] * fireball.s;
            int sx = dx[fireball.d] * fireball.s; // di 방향으로 si 만큼 이동

            int ny = adjustCoordinate(fireball.r, sy);
            int nx = adjustCoordinate(fireball.c, sx); // 좌표 조정

            for (int j = 0; j < fireballCount; j++) {
                if (map[ny][nx][j] == 0) { // nx, ny 좌표에 파이어볼을 위치시킴
                    map[ny][nx][j] = i + 1;
                    break;
                }
            }

            // 이동된 좌표로 바꿈
            fireball.r = ny;
            fireball.c = nx;
        }
    }
	
	// 이동할 좌표가 map 내부인지 확인
	private static int adjustCoordinate(int coordinate, int d) {
        if (d < 0) d = (Math.abs(d) % N) * -1;
        else d = d % N;

        coordinate += d;

        if (coordinate >= 0 && coordinate < N) {
            return coordinate;
        } else if (coordinate >= N) { // 좌표가 N보다 커질 때
            return coordinate - N;
        } else { // 좌표가 0보다 작을 때
            return N + coordinate;
        }
    }
	
	private static List<Fireball> splitTheFireball(List<Fireball> fireballs, int fireballCount, int[][][] map) {
        List<Fireball> move = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (fireballCount > 1 && map[i][j][1] > 0) { // i, j에 두 개 이상의 파이어볼이 있는 경우
                    int tm = 0;
                    int ts = 0;
                    int firstDirection = fireballs.get(map[i][j][0] - 1).d;
                    boolean isAllEvenOrOddDirection = true;
                    int cnt = 0;

                    for (int t = 0; t < fireballCount; t++) {
                        if (map[i][j][t] == 0) break;

                        Fireball fireball = fireballs.get(map[i][j][t] - 1);
                        tm += fireball.m; // 합쳐진 파이어볼 질량의 합
                        ts += fireball.s; // 합쳐진 파이어볼 속력의 합

                        // 전부 홀수이거나 전부 짝수인지 확인
                        if (isAllEvenOrOddDirection) {
                            if (firstDirection % 2 != fireball.d % 2) {
                                isAllEvenOrOddDirection = false;
                            }
                        }
                        cnt++; // 합쳐진 파이어볼의 개수
                    }

                    for (int o = 0; o < 4; o++) {
                        int pm = tm / 5;
                        int ps = ts / cnt;

                        if (pm == 0) break;

                        if (isAllEvenOrOddDirection) {
                            move.add(new Fireball(i, j, pm, ps, o * 2));
                        } else {
                            move.add(new Fireball(i, j, pm, ps, (o * 2) + 1));
                        }
                    }
                } else if (fireballCount > 0 && map[i][j][0] > 0) { // 한 개의 파이어볼만 있는 경우
                    move.add(fireballs.get(map[i][j][0] - 1));
                }
            }
        }

        return move;
    }

}

// 참고 : https://ksb-dev.tistory.com/290
