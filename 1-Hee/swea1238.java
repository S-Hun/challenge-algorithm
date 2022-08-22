package com.ssafy.problem.j0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_SW문제해결기본10일차Contact {
	
	// 41분
	
	static int[][] calls;

	public static void main(String[] args) throws IOException {
		
		
		/*
		 *  인접 행렬을 통해서 bfs 를 구현함.
		 *  인접 행렬의 크기는 최대 100개.
		 */
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int t = 1 ; t <= 10 ; t ++) {
			
			int[][] calls = new int[101][101]; // 얕은 복사 이슈를 피하고 싶어서 지역 변수로 배열 생성.
			
			sb.append("#"+t+" ");
			
			st = new StringTokenizer(br.readLine());
			int orderLength = Integer.parseInt(st.nextToken());
			int vertax = Integer.parseInt(st.nextToken());
			int limit = Integer.MIN_VALUE;
			int max = Integer.MIN_VALUE;

			st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < orderLength/2 ; i ++) {
							
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());			
				
				limit = Math.max(limit, from > to ? from : to); // 배열을 탐색할 limit을 지정해주면, 
				// 배열을 매 테스트케이스마다 1만번 안봐도 되게 할려고 최대 값 = index를 저장.
				
				calls[from][to] = 1;						
			}
					
			ArrayList<String> bfsResult = bfs(vertax, limit, calls); // bfs 로 값을 탐색한 결과 값을 index로 depth가 구분된 ArrayList로 받음.
			st = new StringTokenizer(bfsResult.get(bfsResult.size()-1)); // 문제에서 궁금한건 최고 depth의 node들 중 큰 값을 원하므로 최고 depth 문자열 추출.
			
			while(st.hasMoreTokens()) { // 최고 depth 문자열 = 숫자의 모음 을 토큰화해서,
				int x = Integer.parseInt(st.nextToken());
				max = Math.max(x, max); // 그중 최고 값을 선정.
			}
			
			bfsResult.clear(); 
			sb.append(max).append("\n"); // 결과 값을오 출력.
		}
		System.out.print(sb.toString());
		
	}
	
	private static ArrayList<String> bfs(int vertax, int limit, int[][] calls) { // bfs 알고리즘,
		
		String X;
		boolean[] isVisited = new boolean[limit+1];
		Queue<Integer> q = new LinkedList<>();
		q.offer(vertax);
		isVisited[vertax] = true;
		ArrayList<String> result = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			X = "";
			while(--size >= 0 ) {		// while문을 하나 더 추가해 depth마다 ArrayList에 값을 추가하도록 변경.		
				int cur = q.poll();
				X += cur+" ";
				
				for(int i = 1 ; i <= limit ; i ++) {
					if(!isVisited[i] && calls[cur][i] != 0) {
						isVisited[i] = true;
						q.offer(i);
					}
				}							
			}					
			result.add(X);
			
		}
		
		return result;
		
		
		
	}
	

}
