package com.ssafy.problem.j0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	
	static int[][] maps;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		
		maps = new int[N][N];
		
		for(int x = 0 ; x < N ; x ++) {
			String line = br.readLine();
			for(int y = 0 ; y < N ; y++) {
				maps[x][y] = Integer.parseInt(String.valueOf(line.charAt(y)));
			}
		}
		
		// 분할정복 메서드
		binarydivide(0, 0, N);
		
		System.out.println(sb.toString());
		
	}

	private static void binarydivide(int i, int j, int n) {
				
		if(isOneColor(i,j,n)) {
			// 이 곳에 최대 4개의 값이 올 수 있는데, 4개일지 1개일지는 재귀에 깊이에 달려있음.
			// 재귀의 깊이는 큰 곳에서 작은 곳으로 전부다 수렴하는 것이 아니라,
			// 조건절 isOneColor에 따라서 통과되는 경우에는 괄호 안으로 값이 묶이게 되고,
			// 그렇지 않으면 한번더 분할 정복을 가게 되어 다른 괄호 속에 묶이게 됨.
			sb.append(maps[i][j]);
			return;			
		}
		
		int divideSize = n/2; 
		
		// 이 부분이 분할 정복 재귀의 depth 별로 값을 묶어주는 역할을 함.
		sb.append("(");
		binarydivide(i, j, divideSize);
		binarydivide(i, j+divideSize, divideSize);
		binarydivide(i+divideSize, j, divideSize);
		binarydivide(i+divideSize, j+divideSize, divideSize);
		sb.append(")");
		
		
	}
	
	private static boolean isOneColor(int r, int c, int size) {
		
		
		// 분할 정복 배열 범위에 대한 완전탐색 (전체로 보면 부분탐색)
		int color = maps[r][c];
		
		for(int i = r ;  i < r + size ; i++) {
			for(int j = c ; j < c + size ; j++) {
				if(maps[i][j] != color) return false;
			}
		}
		return true;
		
	}

}
