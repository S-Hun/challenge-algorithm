package com.java.j0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리_Prim_AdjList {
	
	/*
	 * 인접 리스트를 링크드 리스트 개념으로 구현하였습니다.
	 */
	
	static class Node{
		int vertex, weight;
		Node next; // 다음 노드의 주소 값을 담을 멤버 변수 설정.
		public Node(int no, int weight, Node next) {
			super();
			this.vertex = no;
			this.weight = weight;
			this.next = next;
		}				
	}
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Node[] Vertexlist = new Node[V+1];
		
		for(int i = 0 ; i < E ; i ++) { // 간선의 수만큼 반복하며, 간선이 "있는" 경우에만 "정점"에 간선 정보를 추가합니다. 결과적으로 이 방식은 정점 중심임에는 변함이 없습니다.
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 본 문제에서는 무향그래프이므로 대칭으로 인접리스트를 생성합니다.
			Vertexlist[from] = new Node(to, weight, Vertexlist[from]);
			Vertexlist[to] = new Node(from, weight, Vertexlist[to]);			
		}
		
		
		int[] minWeight = new int[V+1]; // 문제에서는 값이 1부터 들어오므로 입력값과 index를 맞춰주기 위해 1을 증가.
		boolean[] isVisited = new boolean[V+1];
		
		Arrays.fill(minWeight, Integer.MAX_VALUE); // prim 알고리즘이 정상작동하게 하기 위해 처음에는 배열에 최대값을 할당해주고,
		minWeight[1] = 0; // 첫번째 요소에서 첫번재 요소로 가는 것은 비용이 0이므로(문제에서 별도 제시하지 않았으므로) 첫 거리비용을 0으로 설정해줍니다.
		
		
		long result = 0; // 문제에서 입력 값으로 int형의 범위를 넘어가는 값이 주어질 수 있어서 long 형으로 결과값을 담을 변수 설정.
		
		for(int i = 0 ; i < V ; i ++) {
			
			// 매 회마다 최소값과, 최소 값의 index를 초기화 해줌.
			int minValue = Integer.MAX_VALUE;
			int minV = -1;
			
			for(int j = 1 ; j <= V ; j ++) { 
				// 방문한적 없고, 최소비용이 가장 작은 정점의 가중치와 index를 추출.
				if(!isVisited[j] && minWeight[j] < minValue) {
					minValue = minWeight[j];
					minV = j;
				}
			}
			
			isVisited[minV] = true; 
			result += minValue; // 최소비용을 누적해주고
			
			// 각 노드에 대해 최소비용을 갱신하는 역할을 하는 반복문,
			// 첫 1회에는 Integer.MAX_VALUE로 찬 배열을 반복할수록 최소비용으로 갱신해주는 역할을 함.
			for(Node temp = Vertexlist[minV] ; temp != null ; temp = temp.next) {
				if(!isVisited[temp.vertex] && 
						temp.weight < minWeight[temp.vertex]){
					minWeight[temp.vertex] = temp.weight;
				}
			}
			
		}
		
		System.out.println(result); // 결과 출력
		


		
		
	}

}
