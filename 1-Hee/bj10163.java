package com.ssafy.problem.for0822Test;

import java.util.Scanner;

// 0 : 36 : 03
// https://www.acmicpc.net/problem/10163

//왼쪽 x, y, 너비, 높이,
//2
//0 0 10 10
//2 2 6 6

public class BOJ_10163_색종이 {
	
	static int [][] paper;
	
	public static void main(String[] args) {
		
		paper = new int[21][21];
		
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt();
		
		for(int i = 0 ; i < P ; i ++) {
			int y1 = sc.nextInt();
			int x1 = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			
			paintMaps(x1,y1, width, height, i+1);
		}
		
		printPaper();
		int[] areas = new int[P+1];
		areas = CheckArea(areas);
		
		for(int i = 1 ; i < areas.length; i ++) {
			System.out.println(areas[i]);
		}
	
		
	}
	
	private static int[] CheckArea(int[] areas) {
		
		for(int i = 0 ; i < paper.length ; i ++) {
			for(int j = 0; j < paper.length ; j ++) {
				if(paper[i][j] != 0) areas[paper[i][j]] ++;
			}
		}
		return areas;
		
	}

	private static void printPaper() {
		for(int i = 0; i < paper.length; i ++) {
			for(int j = 0 ; j < paper.length; j ++) {
				System.out.print(paper[i][j]);
			}
			System.out.println();
		}
		
	}

	
	private static void paintMaps(int x1, int y1, int rowSize, int columnSize, int number) {
		
		int x2 = x1+rowSize;
		int y2 = y1+columnSize;
		
		for(int i = x1; i < x2 ; i ++) {
			for(int j = y1 ; j < y2 ; j++) {
				paper[i][j] = number;		
			}
		}
		
	}
}
