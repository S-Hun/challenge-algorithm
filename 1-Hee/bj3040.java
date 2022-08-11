package com.ssafy.problem.j0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난쟁이 { 

	static int count;
	static int N = 9;
	static int R = 7;
	static int[] inputs = new int[9];
	static int[] numbers = new int[7];
	static int[] answer = new int[7];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		// 조합 문제고, 난쟁이의 키의 값이 중복은 없다고 했으므로 중복 조합이 아님.
		
		for(int i = 0 ; i < 9 ; i ++) {
			inputs[i] = Integer.parseInt(br.readLine());
		}
				
		comb(0, 0);
		
		System.out.println(sb.toString());
		System.out.println();
		System.out.println("\n 전체 연산 횟수는 : "+count);
		
		
		
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == R) { 
			// count++; 
			// 전체 연산의 횟수는 9C7 이므로 고작 36회밖에 안됩니다.
			// 그래서 효율성을 전혀 고려하지 않고 조합으로 풀어도 될거 같아서 그냥 조합으로 풀었습니다.
			
			int sum = 0 ;
			for(int i = 0 ; i < 7 ; i++) { 
				sum += numbers[i]; // 조건식 검사를 위해 각 케이스별 배열의 합을 구하고,
			}

			if(sum==100) { // 무조건 배열의 합이 100인 케이스는 존재한다고 했으므로,
				for(int i = 0 ; i < 7 ; i++) { // 그 경우에는 해당 케이스의 결과값을 정답으로 작성함.
					 sb.append(numbers[i]).append("\n");
				}
			}			
			return;
		}
		
		for(int i = start; i < N ; i ++) {
			
			numbers[cnt] = inputs[i];
			comb(cnt+1, i+1);
			
		}
	}
	
	
	
	
}
