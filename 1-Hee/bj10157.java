package com.ssafy.problem.for0822Test;

import java.util.Scanner;

public class BOJ_10157_자리배정 {
	
	// 26:16
	// https://www.acmicpc.net/problem/10157
	
	static int[][] maps;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		int r = sc.nextInt();
		int target = sc.nextInt();
		
		maps = new int[r][c];
		
		System.out.println(reservation(r, c, target));
		
		sc.close();
		
		
	}

	static final int [] dx = {1, 0, -1, 0};
	static final int [] dy = {0, 1, 0, -1};
	private static String reservation(int r, int c, int target) {
		
		if(r*c< target) return "0";
		
		
		int dr = 0;
		int dc = 0;
		int i = 1;
		
		maps[dr][dc] = i;
		
		int index = 0;
		
		while(i < target) {
			i++;
			
			dr += dx[index];
			dc += dy[index];
			
			if(dr < 0 || dc < 0 || dr >= r || dc >= c || maps[dr][dc] != 0) {
				
				dr -= dx[index];
				dc -= dy[index];
				
				index = (index+1)%4;
				
				dr += dx[index];
				dc += dy[index];
				
			}
			maps[dr][dc] = i;
			
		}
		
		return (dc+1) +" "+ (dr+1);
		
	}

}
