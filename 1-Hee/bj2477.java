package com.ssafy.problem.for0822Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BOj_2477_참외밭 {
	
	// 55분 06초
	// https://www.acmicpc.net/problem/2477
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> hset = new HashSet<>();
		
		int cham = sc.nextInt();
		
		int [][] orders = new int [6][2];
		
		for(int i = 0 ; i < 6 ; i ++) {
			
			int way = sc.nextInt();
			int length = sc.nextInt();
			
			orders[i][0] = way;
			orders[i][1] = length;
		}
		
		int outerSize = 1;
		int innerSize = 1;
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i = 0 ;  i < 6 ; i++) {
			if(orders[i][0] == orders[(i+2)%6][0]) {
				innerSize *= orders[(i+1)%6][1];
				hset.add(orders[i][0]);
			}
		}
		
		for(int i = 0; i < 6 ; i ++) {
			if(!hset.contains(orders[i][0])) {
				outerSize *= orders[i][1];
			}
		}
		
		System.out.println((outerSize - innerSize)*cham);
		
		
		sc.close();
		
	}

}
