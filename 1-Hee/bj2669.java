package com.ssafy.problem.for0822Test;

import java.util.Scanner;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {
	
	// 0 : 23 : 45
	// https://www.acmicpc.net/problem/2669
	// 직사각형 네개의 합집합의 면적 구하기
	// https://www.acmicpc.net/workbook/view/10168

	
	static boolean[][] maps;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		maps = new boolean[101][101];
		
		
		for(int i = 0 ; i < 4 ; i ++) {
			int y1 = sc.nextInt();
			int x1 = sc.nextInt();
			int y2 = sc.nextInt();
			int x2 = sc.nextInt();
			
			paintMaps(x1,y1,x2,y2);
		}
				
		System.out.println(countArea());
		sc.close();
		
		
	}
	
	private static int countArea() {
		int cnt = 0;
		for(int i = 100 ; i >= 0; i--) {
			for(int j = 0 ; j <= 100; j ++) {
				if(maps[i][j]) cnt++;
			}
		}
		return cnt;
	}

	private static void paintMaps(int x1, int y1, int x2, int y2) {
		
		for(int i = x1; i < x2 ; i ++) {
			for(int j = y1 ; j < y2 ; j++) {
				maps[i][j] = true;			
			}
		}
		
	}

}
