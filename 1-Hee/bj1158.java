package com.ssafy.problem.j0808;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158_요세푸스문제 {
	
	public static void main(String[] args) {
		
		/*
		 요세푸스 문제, 배열을 전부 다 탐색하긴 하나 변하는 변수가 두가지가 있다.
		 하나는 배열의 크기, 숫자를 뽑음과 동시에 배열에서 삭제해야하므로 배열의 크기가 바뀐다.
		 둘째는 뽑힌 숫자, 숫자를 연속적으로 뽑는게 아니라 n번째 뒤에 것을 뽑는 식이므로 패턴이 있다.
		 그런데, 여기서 핵심 포인트는 처음 한 1~2번 정도 카드를 뽑을 때는 index를 ++ 해서 뽑는 것처럼 보일 수 있는데,
		 사실은 매번 배열이 줄어들어서 뽑힌 요소는 고려하지 않아야 해서 다음 번을 셈하는게 변칙적일 수 있다.
		 그래서 이런 점을 고려해서 아래와 같이 문제를 풀이했다.		 
		 */
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 초기 배열 크기
		int C = sc.nextInt(); 
		StringBuilder sb = new StringBuilder();
				
		Queue<Integer> q = new LinkedList<>();
		
		List<Integer> member = new ArrayList<>();
		
		for(int i = 0 ; i < N; i ++) { // 1~N을 가지는 배열을 일단 생성하고
			member.add(i+1);
		}
		
		int cnt = C-1; // 첫시작은 배열의 인덱스로 탐색해야 하므로 1을 빼줘서 시작한다.
		while(member.size()>1) { // 마지막 요소가 하나 남을때까지 한다. why? 그 이하는 ArithmeticException 발생. (아래의 일반식때문에 발생함)
			q.offer(member.get(cnt)); // 일단 member의 cnt번째를 꺼내서 넣고,
			member.remove(cnt); // 꺼냈으니 삭제해준다.
			cnt = (cnt+C-1)%member.size(); // 다음 순번은 현재 순번에서 +C만큼 해야하나 
			// -1 된것을 감안해서 셈해야 하고, 이것을 식으로 표현하면 cnt+C-1로 표현 가능 C는 점프? -1은 하나 빠졌으니까 뺌.
			// 그런데 이걸 그대로 탐색하게 되면 범위를 벗어나는데, 그걸 배열 범위 내에서 돌 수 있도록 하려고 배열의 크기로 몫연산을 해줌
			// 이러면 사이즈를 넘어가게 되면 처음 번째부터 셈하게 해서 순회가 가능하게 해준다.
		}
		q.offer(member.get(0)); // 마지막 원소를 수동으로 넣어주고,
		
		sb.append("<"); 
		
		while (q.size()>1) {
			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll()).append(">");
		
		System.out.println(sb); // 양식에 맞추어 String을 작성해서 출력한다.

		
	}

}
