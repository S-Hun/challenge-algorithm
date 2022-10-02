package com.ssafy.problem.j0808;

import java.util.Scanner;

public class swea_9229_한빈이와SpotMart {

	public static int N, M, rank; // 과자의 개수, 과자의 최대 무게, 역대 과자중 M을 넘지 않는 과자의 최대 합
	public static int[] snacks; // 테스트 케이스별 모든 과자 종류를 담는 배열
	public static int[] candidate = new int[2]; // 과자 조합 메서드에 사용될 배열, 2개밖에 못집으므로 크기를 2개로 고정.
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			
			sb.append("#").append(t).append(" ");
			
			rank = -1; // 각 테스트 케이스별로 새롭게 최대합을 구해야하므로 0으로 초기화 해줌.
			N = sc.nextInt(); 
			M = sc.nextInt();
			snacks = new int[N]; // 과자 후보군 크기를 정하고,
			
			for(int i = 0 ; i < N; i++) {
				snacks[i] = sc.nextInt(); // 후보군 크기만큼 과자의 무게들을 담아줌.
			}
			
			comb(0, 0); // 조합 메서드 + 조건식을 추가함, 조건식에 대한 부분은 조합 메서드 기저조건에 주석으로 설명적음.
						
			sb.append(rank).append("\n"); // 만약 조합 알고리즘으로 값을 못찾으면 초기화 값인 -1이 그대로 남아있으므로 이 한줄로 모든 케이스 출력 가능.

			
		}
		System.out.println(sb);
		sc.close();
		
	}
	
	private static void comb(int cnt, int start) {
		
		if(cnt==candidate.length) {
			// 이부분이 기저조건인데			
			int sum = 0;
			for(int n : candidate) {
				sum += n; // 2개긴 하지만, 배열의 값을 다 더해서,
			}
			if (sum <= M && sum > rank ) { // 그 합이 최대치인 M을 초과하지 않으면서 원래 rank = -1 보다 크다면,
				rank = sum; // 그 값으로 갱신해준다.
				// 다음 케이스가 들어와도 위의 조건식을 만족할 때에만 갱신 됨.
			}			
			return; // 재귀 종료.
		}
		
		for(int i = start; i <N ; i++) {
			
			candidate[cnt] = snacks[i]; // 반복문의 i를 배열에 넣게 되면 1~N에 대한 조합이므로, 
			// 지금의 경우 과자 "무게"에 대한 조합이 필요해서 과자 무게를 담은 배열 snacks[]로 조합을 만듦.
			comb(cnt+1, i+1);
		}
		
	}
	
}
