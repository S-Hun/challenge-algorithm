package com.ssafy.problem.j0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class BOJ_2164_카드2 {
 
	public static void main(String[] args) throws IOException {
		
		Queue<Integer> q = new LinkedList<>();		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(br.readLine()); // 전체 큐의 크기 설정
	
		int idx = 1;
		
		while (idx <=N) {
			q.offer(idx);
			idx++;
		}
		
		
		while(q.size() > 1) {
			q.poll();	// 맨 앞의 원소는 버리고,
			q.offer(q.poll());	// 그 다음 원소를 빼내면서 큐의 가장 뒤로 입력.
		}
		
		System.out.println(q.poll());	// 마지막으로 남은 한 장 출력.
	}
}