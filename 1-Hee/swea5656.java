package com.swea.A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
	
	private static class Brick{
		int x, y, power;

		public Brick(int x, int y, int power) {
			this.x = x;
			this.y = y;
			this.power = power;
		}		
		
	}

	static int K, C, R, min;
	static int[][] map;
	static int[] cols;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/swea5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			map = new int[R][C];
			
			for(int i = 0 ; i < R ; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < C ; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			cols = new int[K];
			
			simulation(0);
			sb.append(min).append("\n");
		}
		System.out.println(sb.toString());
		

	}
	
	// 시뮬레이션(중복순열)
	private static void simulation(int idx) {
		if(idx==K) {
			int[][] copy = new int[R][C];
			copyMap(map, copy);
			for(int i = 0 ; i < K ; i ++) {
				int Col = cols[i];
				int Row = getRow(Col, copy);
				if(Row<0) continue;
				boom(Row, Col, copy);
				sorting(copy);
			}
			min = Math.min(min, countBrick(copy));			
			return;
		}
		
		for(int i = 0 ; i < C ; i ++) {
			cols[idx] = i;
			simulation(idx+1);
		}
		
	}
	
	
	// 행 찾기
	
	private static int getRow(int col, int[][] copy) {
		for(int i = 0 ; i < R ; i ++) {
			if(copy[i][col]!=0) return i;
		}
		return -1;		
	}
	
	static void printMap(int[][] map) {
		for(int i = 0 ; i < map.length ; i ++) {
			for(int j = 0 ; j < map[i].length ; j ++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	static void copyMap(int[][] map, int[][] copy) {
		for(int i = 0 ; i < R ; i ++) {
			for(int j = 0 ; j < C ; j ++) {
				copy[i][j] = map[i][j];
			}
		}
		
	}

	
	// boom	
	private static final int dx[] = {-1,1,0,0};
	private static final int dy[] = {0,0,-1,1};	
	private static void boom(int x, int y, int[][] copy) {
		
		Queue<Brick> bricks = new LinkedList<>();
		bricks.offer(new Brick(x, y, copy[x][y]-1));
		copy[x][y] = 0;
		
		while(!bricks.isEmpty()) {
			
			Brick cur = bricks.poll();
			
			for(int d = 0 ; d < 4 ; d ++) {
				int nx = cur.x;
				int ny = cur.y;
				for(int p = 0 ; p < cur.power; p++) {
					nx+= dx[d];
					ny+= dy[d];
					if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
					if(copy[nx][ny]==0) continue;
					if(copy[nx][ny]>1) {
						bricks.offer(new Brick(nx, ny, copy[nx][ny]-1));						
					}
					copy[nx][ny] = 0;
				}
			}
		}
	}
	
	// 배열정렬

	private static Stack<Integer> stk;
	private static void sorting(int[][] map) {
		
		for(int c = 0 ; c < C ; c ++) {
			stk = new Stack<>();
			for(int r = 0 ; r < R ; r++) {
				if(map[r][c]>0) {
					stk.push(map[r][c]);
					map[r][c] = 0;
				}
			}
			
			int r=R-1;
			while(!stk.isEmpty()) {
				map[r--][c] = stk.pop();
			}
			
		}
		
	}
	
	// 카운트..
	
	private static int countBrick(int[][] map) {
		int cnt = 0;
		for(int[] i : map) 
			for(int j : i) 
				if(j>0) cnt++;
		return cnt;
	}
	

}
