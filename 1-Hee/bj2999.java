package practiceForIMBOJ;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2999_비밀이메일 {
	
	// 43 : 24
	
	public static void main(String[] args) throws IOException {
				
		Scanner sc = new Scanner(System.in);		
		ArrayList<Point> candidate = new ArrayList<>();
		String input = sc.nextLine();		
		int N = input.length();
		
		for(int c = 1 ; c <= N ; c ++) {
			for(int r = N ; r >= 1 ; r--) {
				if(r*c==N && r <= c) {
					candidate.add(new Point(r, c));
				}
			}
		}
		
		int R = candidate.get(0).x;
		int C = candidate.get(0).y;
		
		char[] words = input.toCharArray();
		char[][] trans = new char[C][R];
		
		int idx = 0;
		for(int i = 0 ; i < trans.length; i ++) {
			for(int j = 0 ; j < trans[i].length; j ++) {
				trans[i][j] = words[idx++];
			}
		}
		
		
		String x = "";
		
//		for(int i = 0 ; i < trans.length ; i ++) {
//			for(char c : trans[i]) {
//				System.out.print(c+" ");
//			}
//			System.out.println();
//		}
		
		for(int i = 0 ; i < R ;i ++) {
			for(int j = 0 ; j < C ; j ++) {
				x += trans[j][i];
			}
		}
		
		System.out.println(x);
		
		
	}

}
