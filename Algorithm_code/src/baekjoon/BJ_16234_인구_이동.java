package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16234_인구_이동 {
	
	static int N, L, R;
	static int[][] country;
	static boolean[][] visited;
	static ArrayList<Node> list; //인구 이동이 필요한 노드 리스트
	
	static int[] dy = {  0, 0, -1, 1}; // 상, 하, 좌, 우
	static int[] dx = { -1, 1,  0, 0}; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 땅 크기
		L = Integer.parseInt(st.nextToken()); // 최소 인구차
		R = Integer.parseInt(st.nextToken()); // 최대 인구차
		
		country = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(move());
		
	}
	
	//더 이상 인구이동이 일어나지 않을 때까지 반복
	public static int move() { 
        int result = 0; // 인구 이동일 수
        while(true) {
            boolean isMove = false; // 인구 이동 발생 여부
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) { // 방문하지 않았으면 인구이동 가능한지 확인
                        int sum = bfs(i, j); 
                        if(list.size() > 1) {
                            changePopulation(sum); // 인구 이동
                            isMove = true;
                        }    
                    }
                }
            }
            if(!isMove) return result;
            result++;
        }
    }
    
	//bfs탐색으로 열릴 수 있는 국경선 확인 하며 인구 이동할 총 인구수 반환
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>(); 
        
        q.offer(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;
        
        int sum = country[x][y]; // 연합의 총 인구수
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(country[current.x][current.y] - country[nx][ny]);
                    if(L <= diff && diff <= R) {
                        q.offer(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        sum += country[nx][ny];
                        visited[nx][ny] = true;
                    }        
                }
            }
        }
        return sum;
    }
    
    //열린 국경선 내의 노드들 인구 변경
    public static void changePopulation(int sum) {
        int avg = sum / list.size();
        for(Node n : list) {
        	country[n.x][n.y] = avg;
        }
    }
    
    public static class Node {
        int x; 
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
	
}

// 참고 : https://moonsbeen.tistory.com/259

// 문제 해결 방법
//1. 순회를 하며 방문하지 않은 노드를 방문한다. 이 과정은 모든 노드를 방문할 때까지 반복된다.
//2. 노드를 방문할 때에는 BFS/DFS 탐색 알고리즘을 사용하여 구현한다. 이때 다음으로 이동 할 노드는 현재 노드의 값과의 차이가 L이상 R이하여야 한다.
//3. 방문한 노드들을 차례대로 list에 넣어주고 노드 값의 합을 따로 저장해 둔다.
//4. 모든 노드의 방문이 끝났다면 list에 넣어준 노드들의 인구이동을 시작한다. 이때 list의 크기가 1보다 커야 이동을 시작한다.
//5. 이동 시에는 문제의 조건에 맞게 노드 값의 합을 노드의 사이즈로 나눈 값을 모든 노드에 변경시켜준다.
//6. 1 ~ 6과정 동안 인구 이동이 일어난 적이 없다면 더 이상 이동할 수 있는 인구가 없으므로 순회를 멈추고 이때의 result값을 반환한다.
