package com.ssafy.review;

import java.util.Scanner;

public class BOJ_13300_방배정 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		int[][] rooms = new int[2][7];
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i = 0 ; i < N ; i ++) {
			rooms[sc.nextInt()][sc.nextInt()] +=1;			
		}
		
		int roomCnt = 0;
		
		for(int i = 1 ; i <= 6; i ++) {
			if(rooms[0][i]%K==0) roomCnt += rooms[0][i]/K;
			else roomCnt += rooms[0][i]/K + 1;

			if(rooms[1][i]%K==0) roomCnt += rooms[1][i]/K;
			else roomCnt += rooms[1][i]/K + 1;
		}
		
		
		System.out.println(roomCnt);
		
		sc.close();		
		
	}

}
