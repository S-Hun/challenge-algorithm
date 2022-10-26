package com.swea.A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4008_숫자만들기 {
	// 15분
	
	static int[] operator;
	static int[] numbers;
	static int N, min, max;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/swea4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			N = Integer.parseInt(br.readLine());
			operator = new int[N-1];
			numbers = new int[N];
			
			int idx = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 4; i ++) {
				int x = Integer.parseInt(st.nextToken());
				for(int j = 0 ; j < x; j ++) {
					operator[idx++] = i+1; 
				}				
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N; i ++) 
				numbers[i] = Integer.parseInt(st.nextToken());
			
			do {
				int result = calcNumbers(operator);
				min = min < result? min : result;
				max = max > result? max : result;
			}while(NP(operator));
			
			sb.append(max-min).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int calcNumbers(int[] ops) {
		int result = numbers[0];
		
		for(int i=0 ; i < N-1 ; i ++) {
			switch(ops[i]) {
				case 1:
					result += numbers[i+1];
					break;
				case 2:
					result -= numbers[i+1];					
					break;
				case 3:
					result *= numbers[i+1];										
					break;
				case 4:
					result /= numbers[i+1];										
					break;
			}
		}
		return result;
		
	}
	
	private static boolean NP(int [] numbers) {
		int N = numbers.length;
		int i = N-1;
		while(i>0 && numbers[i-1]>= numbers[i])--i;
		if(i==0) return false;
		int j = N-1;
		while(numbers[i-1]>=numbers[j])--j;
		swap(numbers, i-1, j);
		int k = N-1;
		while(i<k) swap(numbers, i++, k--);
		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;		
	}
	


}
