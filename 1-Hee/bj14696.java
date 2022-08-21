package com.ssafy.problem.for0822Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {
	
	// 0 : 30 : 00
	// https://www.acmicpc.net/problem/14696

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringTokenizer st1;
		StringTokenizer st2;
		StringBuilder sb = new StringBuilder();
				
		
		int Round = sc.nextInt();
		int[] A = new int[5];
		int[] B = new int[5];
		sc.nextLine();
		
		for(int i = 0 ; i < Round ; i ++) {
			st1 = new StringTokenizer(sc.nextLine());
			st2 = new StringTokenizer(sc.nextLine());
			st1.nextToken();
			st2.nextToken();
			
			int max1 = -1;
			int max2 = -1;
			
			while(st1.hasMoreTokens()) {
				int x = Integer.parseInt(st1.nextToken());
				max1 = Math.max(max1, x);
				A[x]++;
			}
			
			while(st2.hasMoreTokens()) {
				int y = Integer.parseInt(st2.nextToken());
				max2 = Math.max(max2, y);
				B[y]++;
			}
			
			boolean isWin = false;
			for(int x = max1>max2? max1 : max2 ; x > 0 ; x--) {
				if(A[x] > B[x]) {
					sb.append("A").append("\n");
					isWin = true;
					break;
				}
				else if(A[x] < B[x]) {
					sb.append("B").append("\n");
					isWin = true;
					break;
				}
			}
			if(!isWin) sb.append("D").append("\n");				
			
						
			Arrays.fill(A, 0);
			Arrays.fill(B, 0);			
			
		}
		System.out.println(sb.toString());
		
		sc.close();
		
		
		
	}

}
