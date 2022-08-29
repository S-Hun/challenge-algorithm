package com.java.j0824;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	
	// 30분
	

	static int W, H, cnt;
	public static void main(String[] args) throws IOException{
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
						
		while(true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			// h 개만큼 행의 정보가 공백으로 구분되어 들어온다.
			H = Integer.parseInt(st.nextToken());
			
			if(W==0 && H==0) break;
			int[][] maps = new int[H][W];
			// 배열의 크기에 상응하는 방문 배열
			boolean[][] isVisited = new boolean[H][W];

			// 맵을 생성하고,
			for(int i = 0 ; i < H ; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < W ; j++) {
					maps[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			search(maps, isVisited);
			
			System.out.println(cnt);
			cnt = 0;
			
			
			
			
		}
		
	}
	private static void printMaps(int[][] maps) {
		for(int i = 0 ; i < H ; i ++) {
			for(int j = 0 ; j < W ; j ++) {
				System.out.print(maps[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	private static void search(int[][] maps, boolean[][] isVisited) {
		for(int h = 0; h < H ; h++) {
			for(int w = 0 ; w < W; w++ ) {
				if(!isVisited[h][w] && maps[h][w] != 0) {	// 해당 칸을 방문 한적 없으면,
					markIsland(maps, isVisited, h, w); //연결되는 섬을 마킹한다.
					cnt++;
				}
			}
		}
		
	}
	
	static final int dx[] = {-1, 0, 1, 0, -1, -1, 1, 1};
	static final int dy[] = {0, -1, 0, 1, -1, 1, -1, 1};
	private static void markIsland(int[][] maps, boolean[][] isVisited, int x, int y) {
		
		Queue<Point> q = new LinkedList<>();
		isVisited[x][y] = true;
		q.offer(new Point(x, y));
		
		while(!q.isEmpty()) {
			
			Point cur = q.poll();
			isVisited[cur.x][cur.y] = true;
						
			for(int i = 0 ; i < 8 ; i ++) {
				
				int dr = cur.x + dx[i];
				int dc = cur.y + dy[i];
				if(dr < 0 || dc < 0 || dr > H-1 || dc > W-1) continue;
				if(!isVisited[dr][dc] && maps[dr][dc]!=0) {
					isVisited[dr][dc] = true;
					q.offer(new Point(dr, dc));
				}
			}
			
		}	
		
	}
	

}

/*
//지도의 사이즈를 받는다 n x h이고 n h 로 들어옴
//h 개만큼 행의 정보가 공백으로 구분되어 들어온다.
//배열을 생성하고, 
//배열의 크기에 상응하는 방문 배열도 만들고,
// 배열을 완전 탐색한다.
 /델타배열을 통해 갈 수 있는 데 까지 사방으로 진행한다.
//진행이 불가하면, 카운트 계수 올리고, 
//다음 완탐을 진행하는데, 방문배열을 참조해서 안간 곳만 또한다.
*/