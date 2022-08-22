package com.ssafy.problem.j0818;

import java.util.Scanner;

public class BOJ_9663_NQueen {
	
	static int N, cols[], ans;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cols = new int[N];
		
		
		setQueen(0);
		System.out.println(ans);
		sc.close();

	}

	private static void setQueen(int row) {
		
		// setQueen 메서드에서 백드래킹 필터(?)가 되어주는 부분.
		if(!isPossible(row-1)) {
			return;
		}
		
		// 무사히(?) 모든 퀸의 배치가 종료되면 행의 값이 최대값에 수렴하므로 종료하고, 카운트 계수 ans를 올려줘서 가능한 경우를 셈함.
		if(row >= N) {
			ans++;
			return;
		}
		
		// 백트래킹의 회귀? 부분을 담당할 반복문이다, 각각의 '행'위 위치에서 '열'만을 반복문을 돌려서 가능한 경우의 수를 던진다.
		for(int i = 0 ; i < N ; i ++) {
			cols[row] = i; // 현재 행에서의 '열' 정보를 저장하고,
			setQueen(row+1); // 행의 크기를 증가시켜 다음 경우의 수로 넘어간다.
		}
	}
	
	private static boolean isPossible(int row) {
		
		// N-Queen의 백트래킹 기능을 담당하는 로직이다.
		// Queen의 위치 정보를 담은 배열을 순회하면서 자신과 1) 행이 같은지 2) 대각선에 있진 않은 지를 검사하고,
		// 가능하다면 반복문을 무사히 빠져 나올 것이므로, default 리턴 값으로 true를 준다.
		
		for(int i = 0 ; i < row ; i++) {
			if(cols[i] == cols[row] ||
					row - i == Math.abs(cols[i]-cols[row])) {
				return false;
			}
		}
		
		return true;
		
	}

}
