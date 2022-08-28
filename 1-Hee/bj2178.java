package com.java.j0823;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {

	// 23 : 09
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] maps = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			String[] row = br.readLine().split("");
			for(int j = 0 ; j < M ; j++) {
				maps[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		bfs(0, 0, maps);
		
		System.out.println(maps[N-1][M-1]);
		
	}
	
	static final int[] dx = {-1, 0, 1, 0};
	static final int[] dy = {0, -1, 0 ,1};
	
	private static void bfs(int x, int y, int[][] maps) {
		
		/*
		 * 미로탐색 이나 그래프에서 bfs를 사용하면 원하는 목표를 찾을때 까지,
		 * 정말 사람이 미로 탐색하듯이 탐색할 수 있다. , bfs라고 반드시 depth 별로 값을 찾는데
		 * 사용한다는 고정 관념을 버릴 필요가 있겠다.
		 */
		
		// 이번 문제에서는 Point라는 클래스를 이용해
		// 큐에 값을 담는 식으로 탐색했따. Point 클래스는 멤버변수로 x, y가 있는데
		// 이걸 이용하면 좌표를 간단히 저장할 때, 사용하기 좋아서 굳이 클래스 만들지 않아도 됨.
		// 이런 그래프 탐색 문제에서 되게 간편하게 사용 가능해서 좋은듯.
		
		Queue<Point> qp = new LinkedList<>();
		boolean[][] isVisited = new boolean[N][M]; // 2차원 배열 그래프에 대한 방문 배열!
		qp.offer(new Point(x, y));
		isVisited[x][y] = true;
		
		// 전형적인 bfs 알고리즘인데,
		int cnt = 0;
		while(!qp.isEmpty()) {
			Point curP = qp.poll();
			isVisited[curP.x][curP.y] = true;
			
			for(int i = 0 ; i < 4 ; i ++) { // 여기부분에 델타배열을 위한 반복문을 추가해서
				int dr = curP.x + dx[i]; // 사방을 탐색하고,
				int dc = curP.y + dy[i];
								
				if( dr < 0 || dc < 0 || dr >= N || dc >= M) continue; // 이동이 가능한지 점검 후
				
				if(!isVisited[dr][dc]&& maps[dr][dc] == 1) { // 방문하지 않고, 방문가능하면(=1 이면)
					isVisited[dr][dc] = true; // 방문처리 해주고,
					maps[dr][dc] = maps[curP.x][curP.y]+1; // 배열 자체에 증가 값을 같이 전달해줌.
					qp.offer(new Point(dr, dc)); // q에 이동 가능한 좌표의 값을 넣어준다.
				}
			}
		}
	}

}
