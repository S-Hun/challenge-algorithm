package com.ssafy.problem.j0811;


import java.util.Scanner;

public class BOJ_2961_도영이가만든맛있는음식 {
	
	static int min = Integer.MAX_VALUE;
	static int N, R;
	static String[] numbers, input;
	
	public static void main(String[] args) {
		
		/*
		 이 문제를 푸는데 사용한 키 포인트 : 조합
		 엄연히 따지면, 각 케이스별로 2종류이고, 4개만 입력 받아도 8개의 선택지가 생기는데 문제에서
		 " 시거나 쓴 음식을 좋아하는 사람은 많지 않다. 도영이는 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 "
		 라는 구문에서 양념을 하나만 몰아서 쓰지 말라는 것이라는 것이구나 하고 판단, 그래서 각각의 입력 케이스를 하나의 '경우'로 봐야하고,
		 각각의 경우를 선택하면 왼쪽 요소는 누적곱의 연산을 오른쪽의 요소는 누적합의 연산을 해야한다.
		 그래서 그냥 모든 조합에 대해 각각 누적곱과 누적합 값을 구하고 그 차이가 최소인 것을 고르는 방법으로 풀었습니다.		 
		 */
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 테스트 케이스 수 입력받고,
		sc.nextLine();
			
		input = new String[N];
		
		// 각각의 양념 조합?을 입력받고
		for(int i = 0 ; i < N ; i ++) {
			input[i] = sc.nextLine();
		}
		
		// 양념을 다 사용하는 경우 ~ 양념을 하나씩만 사용하는 경우 전부 계산시켜서,
		for(R=N ; R > 0; R--) {
			numbers = new String[R];
			comb(0, 0);
		}
		
		System.out.println(min); // 그중에 최소인 값을 출력.
		sc.close();
				

	}
	
	private static void comb(int cnt, int start) { 
		
		if(cnt == R) {
			
			int sum1 = 1;
			int sum2 = 0;
			
			for(int i = 0 ; i < numbers.length; i ++) {
				String[] X = numbers[i].split(" ");
				sum1 *= Integer.parseInt(X[0]); // 왼쪽 요소는 누적곱
				sum2 += Integer.parseInt(X[1]); // 오른쪽 요소는 누적합
			}
			
			min = Math.min(min, Math.abs(sum1-sum2));
			
			return;
		}
				
		for(int i = start ; i < N ; i++) {

			numbers[cnt] = input[i];
			
			comb(cnt+1, i+1);
		}
		
		
	}
	
	
}
