package bakjoon2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class bj1260_DFS_BFS {
	
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int X1 = sc.nextInt();
		int X2 = sc.nextInt();
		int X3 = sc.nextInt()-1;
		sc.nextLine();

		int[][] graph = new int[X1][X1];		
		boolean[] visited1 = new boolean[X1];
		boolean[] visited2 = new boolean[X1];

		
		for(int i = 0 ; i < X1 ; i ++) {
			for(int j = 0 ; j < X1; j ++) {
				graph[i][j] = -1;
			}
		}
										
				
		for(int i = 0 ; i < X2; i ++) {
			
			int first = sc.nextInt()-1;
			int second = sc.nextInt()-1;
			sc.nextLine();
			
			graph[first][second] = second;
			graph[second][first] = first;			
		}

		// DFS 탐색법, 본 문제에서는 재귀를 사용하는 방법을 씀.		
		dfs(X3, visited1, graph);
		System.out.println();
		
		// BFS 탐색법
		Queue<Integer> Queue = new LinkedList<>();
		
		Queue.add(X3);
		visited2[X3] = true;
		
		while(!Queue.isEmpty()) {
			int pollIndex = Queue.poll();
			System.out.print((pollIndex+1)+ " ");
			
			for(int member : graph[pollIndex]) {
				if(member!=-1) {
					if(!visited2[member]) {
						Queue.add(member);
						visited2[member] = true;
					}
				}
			}			
		}
							
	}
	
	static void dfs(int searchNode, boolean[] visited, int[][] graph) {
		visited[searchNode]=true;
		
		System.out.print((searchNode+1) + " ");
		
		for(int member : graph[searchNode]) {			
			if(member!=-1) {
				if(!visited[member]) {
					dfs(member, visited, graph);
				}				
			}			
		}		
		
	}

}
