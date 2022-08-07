package com.ssafy.problem.j0804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class SWEA_1225_SW문제해결기본_7일차_암호생성기 {

	static Queue<Integer> q = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("data/sw1225.txt"));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int caseNm = -1;
		
		for(int tc = 1 ; tc <= 10 ; tc ++) {
			
			caseNm = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine()); 
			
			while(st.hasMoreTokens()) { // 비밀번호는 총 8가지 이므로 8개의 토큰으로 알아서 잘림.
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			int temp = -1; // 큐에서 빼낸 값을 잠시 저장할 정수 변수, 반복문의 종료 조건에 대한 불합을 결정함.
			int idx = 1; // 문제에서 말하는 비밀번호 감소 규칙 1,2,3,4,5로 계속 돌게 할 변수 만듦.
			
			sb.append("#").append(tc).append(" "); // #1 요부분 만들고,
			
			while(true) {
				temp = q.poll();
				if(temp-idx<=0) { // 규칙에 따라 번호를 idx로 차감했을 때 0보다 같거나 작으면 반복 중지해야함.
					q.offer(0); // 이 때의 마지막 자리는 무조건 0이므로 0을 넣어주고,
					
					for(int i = 0 ; i < 8 ; i ++) { // 8개의 자리이므로 8번 반복해서
						sb.append(q.poll()+" ");  // queue에 있는 값을 빼서 StringBuilder에 양식 맞춰 붙이고
					}
					sb.append("\n"); // 다음 케이스를 위해 개행 문자 삽입.					
					break;
				}
				
				q.offer(temp-idx);							
				idx = (idx++)%5+1; // 이 식을 이용해서 idx가 1~5를 계속 돌게 함.	
			}
		}
		
		System.out.println(sb.toString()); // 최종 정답 문자열 일괄 출력.
				
	}

}
