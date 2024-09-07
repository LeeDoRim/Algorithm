package solved.class1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10809_알파벳_찾기 {

	static String str;
	static int[] alphabet = new int[26];
	static boolean[] first = new boolean[26];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		Arrays.fill(alphabet, -1);
		
		for (int i = 0; i < str.length(); i++) {
			char alpha = str.charAt(i);
			
			switch (alpha) {
			case 'a': if(!first[0]) { alphabet[0] = i; first[0] = true; } break;
			case 'b': if(!first[1]) { alphabet[1] = i; first[1] = true; } break;
			case 'c': if(!first[2]) { alphabet[2] = i; first[2] = true; } break;
			case 'd': if(!first[3]) { alphabet[3] = i; first[3] = true; } break;
			case 'e': if(!first[4]) { alphabet[4] = i; first[4] = true; } break;
			case 'f': if(!first[5]) { alphabet[5] = i; first[5] = true; } break;
			case 'g': if(!first[6]) { alphabet[6] = i; first[6] = true; } break;
			case 'h': if(!first[7]) { alphabet[7] = i; first[7] = true; } break;
			case 'i': if(!first[8]) { alphabet[8] = i; first[8] = true; } break;
			case 'j': if(!first[9]) { alphabet[9] = i; first[9] = true; } break;
			case 'k': if(!first[10]) { alphabet[10] = i; first[10] = true; } break;
			case 'l': if(!first[11]) { alphabet[11] = i; first[11] = true; } break;
			case 'm': if(!first[12]) { alphabet[12] = i; first[12] = true; } break;
			case 'n': if(!first[13]) { alphabet[13] = i; first[13] = true; } break;
			case 'o': if(!first[14]) { alphabet[14] = i; first[14] = true; } break;
			case 'p': if(!first[15]) { alphabet[15] = i; first[15] = true; } break;
			case 'q': if(!first[16]) { alphabet[16] = i; first[16] = true; } break;
			case 'r': if(!first[17]) { alphabet[17] = i; first[17] = true; } break;
			case 's': if(!first[18]) { alphabet[18] = i; first[18] = true; } break;
			case 't': if(!first[19]) { alphabet[19] = i; first[19] = true; } break;
			case 'u': if(!first[20]) { alphabet[20] = i; first[20] = true; } break;
			case 'v': if(!first[21]) { alphabet[21] = i; first[21] = true; } break;
			case 'w': if(!first[22]) { alphabet[22] = i; first[22] = true; } break;
			case 'x': if(!first[23]) { alphabet[23] = i; first[23] = true; } break;
			case 'y': if(!first[24]) { alphabet[24] = i; first[24] = true; } break;
			case 'z': if(!first[25]) { alphabet[25] = i; first[25] = true; } break;
			}
		}
	
		for (int i = 0; i < 26; i++) {
			System.out.print(alphabet[i] + " ");
		}
		
	}
	
}
