package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1991_트리_순회 {
	static int N;
	static Node root = new Node('A', null, null);
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(root, value, left, right);
		}
		
		// 전위 순회
		preOrder(root);
		System.out.println();
		
		// 중위 순회
		inOrder(root);
		System.out.println();
		
		// 후위 순회
		postOrder(root);
	}

	static class Node {
		char value;
		Node left;
		Node right;

		Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	// 이진 트리 입력
	public static void insertNode(Node tmp, char value, char left, char right) {
        if (tmp.value == value) { // 이진트리에 value 값이 저장된 노트에 자식 노드 추가
            tmp.left = (left == '.' ? null : new Node(left, null, null));
            tmp.right = (right == '.' ? null : new Node(right, null, null));
        } else { 
            if (tmp.left != null) { // 이진 트리의 왼쪽 노드 중 value값 찾기
                insertNode(tmp.left, value, left, right);
            }
            if (tmp.right != null) { // 이진 트리의 오른쪽 노드 중 value값 찾기
                insertNode(tmp.right, value, left, right);
            }
        }
    }
	
	// 전위 순회
	private static void preOrder(Node node) {
        if (node == null) 
            return;

        System.out.print(node.value); // 출력
        preOrder(node.left); // 왼쪽 노드 탐색
        preOrder(node.right); // 오른쪽 노드 탐색
    }

	// 중위 순회
    private static void inOrder(Node node) {
        if (node == null) 
            return;
        
        inOrder(node.left); // 왼쪽 노드 탐색
        System.out.print(node.value); // 출력
        inOrder(node.right); // 오른쪽 노드 탐색
    }

    // 후위 순회
    private static void postOrder(Node node) {
        if (node == null)  
            return;
        
        postOrder(node.left); // 왼쪽 노드 탐색
        postOrder(node.right); // 오른쪽 노드 탐색
        System.out.print(node.value); // 출력
    }

}

// 참고 : https://stdio-han.tistory.com/138
