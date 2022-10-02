package com.ssafy.problem.j0809;

import java.util.Scanner;

public class BOJ_2563_색종이 {

	static int[][] paper = new int[101][101]; // 전체 도화지
	static int area;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0 ; i < N ; i++) {
			// 각 케이스별로 정사각형을 그릴 왼쪽 아래의 좌표가 주어짐.
			// 도형의 크기는 정사각형 이므로 좌표 1개만으로 전체 넓이를 그릴 수 있음.
			int x = sc.nextInt();
			int y = sc.nextInt();
			paperPainting(x,y); // static 배열 paper에 입력받은 값을 기준으로 도형을 배열에 그리는 메서드
		}
		
		paperArea(); // 전체 배열에서 색칠된 부분을 count하여 면적을 구하는 메서드
		System.out.println(area);
		
		
	}
	
	private static void paperPainting(int x, int y) {
		
		for(int r = 0 ; r < 10; r ++) {
			for(int c = 0 ; c < 10; c++) {
				// 처음은 배열이 전부 0으로 초기화 되어 있는데,
				// 2번째부터 이미 그린 곳은 어차피 겹치는 부분이므로 그릴 필요 없음.
				// 그래서 조건문과 continue를 이용해 겹치는 영역은 패스함.
				if(paper[r+x][c+y]!=0) continue;
				paper[r+x][c+y] = 1;
			}
		}
		
		
	}
	
	private static void paperArea() {
		
		for(int r = 1 ; r <= 100 ; r++) {
			for(int c = 1 ; c <= 100; c++) {
				if(paper[r][c]==1) area++; // 배열을 완전탐색해서 전체 면적 구함.
			}
		}
	}
}
