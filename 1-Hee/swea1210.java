package com.ssafy.problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA_1210_SW문제해결기본_Ladder1 {

	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("data/sw1210.txt"));		
		Scanner sc = new Scanner(System.in);
				
		for(int tc = 0 ; tc < 10; tc++) {
			int m = sc.nextInt();
			
			// 2차원 배열을 받자			
			byte [][] ladder = new byte[100][100]; // 100 * 100의 배열을 생성.
			byte targetColumn = 0; // 목적지인 2가 있는 곳의 열(col) 좌표를 저장할 변수
			
			for(byte i = 0 ; i < 100; i ++) { 
				for(byte j = 0; j <100; j++) { 
					int member = sc.nextInt();
					if(member==2) targetColumn = j; // 값을 저장하면서 혹시 2면, 그 때의 열 index j를 저장.
					ladder[i][j] = (byte) member;
				}				
			}
			
			
			byte r = 99;  // 제일 아래부터 거꾸로 올라가야해서 배열의 마지막 인덱스!
			byte c = targetColumn;
			byte d = 1; // 제일 첫 동작은 위로 올라가기!

			byte [] dr = { 0, -1, 0 }; // 행의 움직임은 올라가는것 뿐
			byte [] dc = { -1, 0, 1 }; // 열의 움직임은 좌 정지 우
			byte [] di = { 0, 1, 2 }; 
						
			while (r!=0) {
															
				r += dr[di[d]];
				c += dc[di[d]];
				ladder[r][c] = 0;
				
				// 범위 벗어나거나,
				// 1이 아닌 곳으로 이동하면 실행 취소
				if(r < 0 || c < 0 || r > 99  || c > 99 || ladder[r][c] != 0) {
				
					r -= dr[di[d]];
					c -= dc[di[d]];					
				}				
				
				// 시작을 직진으로 두었으나 혹시 좌측 또는 우측에 1이 있으면 방향 전환해야함.
				if( c > 0 && ladder[r][c-1] == 1) { // 좌측이 우선순위
					d = 0;
				}else if(c < 99 && ladder[r][c+1] == 1) { // 2순위는 우측
					d = 2;
				}else { // 둘다 해당 안되면 위로 올라가는 것 지속;
					d = 1;
				}
				
				
								
			}
			
			
			System.out.println("#"+m+" "+c); // 결과값 출력.
					
			
		}
				
	}

}
