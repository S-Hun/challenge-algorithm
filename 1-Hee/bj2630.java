package com.ssafy.problem.j0816;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이 {
	
	static int[][] maps;
	static int white, blue;
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		System.setIn(new FileInputStream("data/bj2630.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		maps = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 분할정복 메서드
		binarydivide(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
		
		
		
	}

	private static void binarydivide(int i, int j, int n) {
		
		/*
		 * 문제에서 배열은 정사각형이고 정사각형의 변의 길이는 짝수라는 제약조건을 줌.
		 * 그래서 n으로 계속 나누면 결국 1으로 수렴할 수 있음.
		 */
		
		
		// 맵의 i, j, n의 영역이 한가지 색깔이라라면, 색깔에 따라서 white 또는 blue의 값을 증가시켜 전체 영역을 셈함.
		if(isOneColor(i,j,n)) { // if 조건절에 오는 이 함수가 핵심적 역할음 함.
			if(maps[i][j]==0) white++;
			else blue++;
			return;			
		}
		
		int divideSize = n/2; // 재귀적으로 binarydivide 메서드를 부를때 size는 계속해서 반으로 줄어야 하므로 2로 나누어줌.
		
		// 나누는 영역이 4분할이므로 4분할에 대해 각각 재귀적으로 값을 넘김.
		binarydivide(i, j, divideSize);
		binarydivide(i, j+divideSize, divideSize);
		binarydivide(i+divideSize, j, divideSize);
		binarydivide(i+divideSize, j+divideSize, divideSize);
		
		
	}
	
	private static boolean isOneColor(int r, int c, int size) {
		
		// arg로 들어온 값 r,c 를 기반으로 기준 색상을 정함 0또는 1
		int color = maps[r][c];
		
		for(int i = r ;  i < r + size ; i++) {
			for(int j = c ; j < c + size ; j++) {
				// 2중 반복문을 통해서 부분탐색을 진행하는데 그 영역 내에서
				// 서로 다른 색깔이 존재하면 divide의 대상이므로 색을 종료하고 false 를 리턴.
				if(maps[i][j] != color) return false;
			}
		}
		
		// 위의 반복문 속 if절을 통과하지 못했다 = 모두 같은색깔이다 이므로 true를 리턴.
		return true;
		
	}

}
