package com.ssafy.problem.j0809;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_6485_삼성시의버스노선 {
	
	static int[] busStop = new int[5001]; // 삼성 시외버스 노선의 최대값
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = sc.nextInt();
		
		for(int t = 1 ; t<=TC; t++) {			
			sb.append("#").append(t).append(" "); // 결과값 헤더,
			
			int lines = sc.nextInt();
			
			for(int i = 0 ; i < lines; i ++) { // 전체 노선의 수만큼 반복해서,
				int x = sc.nextInt(); // 노선 별 시작점
				int y= sc.nextInt(); // 노선 별 종착점
				
				for(int j = x; j <= y; j++) { //  시작점 ~ 종착점 버스정류장에 +=1 해줘서 마킹해주고,
					busStop[j] += 1;
				}
				
			}
			int stops = sc.nextInt(); // 출력을 원하는 버스 정류장의 개수를 입력받아서 
			
			for(int i = 0 ; i < stops; i++) {
				int x = sc.nextInt();
				sb.append(busStop[x]).append(" "); // 버스 정류장 배열에 바로 접근하여 지가나는 노선의 수를 찾아옴.
			}
			sb.append("\n"); 
			
			// 버스 정류장별로 출력이 끝나면, 다음 케이스에서 배열을 활용해야 하므로 0으로 초기화 해줌.			
			Arrays.fill(busStop, 0);

		}
		
		System.out.println(sb); // 최종 결과 산출
		sc.close();
		
		
	}

}
