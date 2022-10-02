package com.ssafy.problem.for0822Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2568_종이자르기 {
	
	// 28분 12초
	// https://www.acmicpc.net/problem/2628

	
	public static void main(String[] args) {
		// 크기 최대값은 100
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
				
		int P = sc.nextInt();
		
		ArrayList<Integer> cutX = new ArrayList<Integer>();
		ArrayList<Integer> cutY = new ArrayList<Integer>();


		
		for(int i = 0 ; i < P ; i ++) {			
			int way = sc.nextInt();
			int number = sc.nextInt();
			if(way==0) cutY.add(number);
			else cutX.add(number);					
		}
		
		cutX.add(N);
		cutY.add(M);
		
		Collections.sort(cutX);
		Collections.sort(cutY);
		
		int startX = 0;
		int maxX = -1;
		for(int i = 0 ; i < cutX.size(); i++) {
			int width = cutX.get(i) - startX;
			maxX = Math.max(maxX, width);
			startX = cutX.get(i);			
		}
		
		int startY = 0;
		int maxY = -1;
		for(int i = 0 ; i < cutY.size(); i++) {
			int width = cutY.get(i) - startY;
			maxY = Math.max(maxY, width);
			startY = cutY.get(i);			
		}
		
		System.out.println(maxX*maxY);


		
		
		
	}


}
