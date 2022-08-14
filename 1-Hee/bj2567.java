package com.ssafy.problem.j0809;

import java.util.Scanner;

public class BOJ_2567_색종이2 {
		
	static int[][] paper = new int[101][101];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			paperPainting(x,y); // 여기까지는 색종이 1처럼 일단 면적을 그림.
		}
		System.out.println(Boundary());						
	}
	
	private static void paperPainting(int x, int y) {
				
		for(int r = 0 ; r < 10; r ++) {
			for(int c = 0 ; c < 10; c++) {
				if(paper[r+x][c+y]!=0) continue;
				paper[r+x][c+y] = 1;
			}
		}
	}
	
	private static int Boundary() {
		
		int cnt = 0;
		// 내부의 도형까지 둘레를 그리는 방법은 배열의 칸이 값이 1일때 
		// 그 주위가 0이면 그것은 곧 둘레가 되므로 0인 부분의 개수를 셈하는 것은 곧 둘레를 재는 것임.
		
		for(int r = 1 ; r <= 100 ; r++) {
			for(int c = 1 ; c <= 100; c++) {
				if(paper[r][c]==1) {
					
					// 상, 하, 좌, 우 모두 탐색해서 0인 부분이면 전부 셈함.
					if(paper[r-1][c]==0) cnt++;
					if(paper[r+1][c]==0) cnt++;
					if(paper[r][c-1]==0) cnt++;
					if(paper[r][c+1]==0) cnt++;					
					
				}
			}
		}
		
		return cnt; // 배열을 전부 탐색해서 구한 cnt = 둘레!
	}

}
