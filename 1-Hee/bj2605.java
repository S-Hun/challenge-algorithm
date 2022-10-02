package com.ssafy.problem.for0822Test;

import java.util.Scanner;


public class BOJ_2605_줄세우기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		
		int[] members = new int[N];
		int[] numbers = new int[N];
		
		for(int i = 0 ; i < N ; i ++) {
			numbers[i] = sc.nextInt();
			members[i] = i + 1;
		}
		
		
		for(int i = 0 ; i < members.length; i++) {			
			for(int j = i; j > i-numbers[i] ; j --) {
				int temp = members[j];
				members[j] = members[j-1] ;
				members[j-1] = temp;
			}
		}
		
		for(int c : members) {
			sb.append(c+" ");
		}
		sb.append("\n");
		System.out.print(sb.toString());
		
		sc.close();
		
		
	}
}
