package com.swea.A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5653_줄기세포배양 {
	
	static class Cell implements Comparable<Cell> {
		int x, y, life, cnt;
		boolean isDead;

		public Cell(int x, int y, int life, int cnt) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Cell o) {
			return -Integer.compare(this.life, o.life);
		}
		
	}

	
	static int[][] map;

	static boolean [][] isVisited;
	static PriorityQueue<Cell> pq;
	static Queue<Cell> temp;
	
	static int R, C, K;
	static int FR, FC;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/swea5653.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			FR = K*3;
			FC = K*3;
			
			isVisited = new boolean[FR][FC];
			pq = new PriorityQueue<>();
			temp = new LinkedList<>();
			map = new int[FR][FC];
			
			int mr = FR/2-1;
			int mc = FC/2-1;
			for(int i = mr ; i < mr+R ; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = mc ; j < mc+C; j ++) {
					int x = Integer.parseInt(st.nextToken());
					if(x==0)continue;
					pq.offer(new Cell(i, j, x, x*2));
					isVisited[i][j] = true;
				}
			}
			
			bfs();						
			sb.append(pq.size()).append("\n");						
		}
		System.out.println(sb.toString());
		
	}
	
	private static void printCell(int[][] map) {
		
		for(int i = 0 ; i < FR ; i ++) {
			for(int j = 0 ; j < FC ; j ++) {
				System.out.print(map[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	private static int countCell(Cell[][] map) {
		
		int cnt = 0;
		for(int i = 0 ; i < FR ; i ++) {
			for(int j = 0 ; j < FC ; j ++) {
				if(map[i][j]!=null) cnt++;
			}
		}
		return cnt;
	}

	private static final int[] dx = {-1,1,0,0};
	private static final int[] dy = {0,0,-1,1};
	private static void bfs() {
		
		
		for(int k = 0 ; k < K ; k ++) {	
			
			while(!pq.isEmpty()){
				Cell cur = pq.poll();
				cur.cnt -= 1;
				
				if(cur.life > cur.cnt) {
					for(int d = 0; d < 4 ; d ++) {
						int nx = cur.x + dx[d];
						int ny = cur.y + dy[d];
						if(nx < 0 || ny < 0 || nx >= FR || ny >= FC) continue;
						if(isVisited[nx][ny]) continue;					
						isVisited[nx][ny] = true;
						temp.offer(new Cell(nx, ny, cur.life, cur.life*2));
					}				
					
				}
				if(cur.cnt != 0) temp.offer(new Cell(cur.x, cur.y, cur.life, cur.cnt));
			}
			
			while(!temp.isEmpty()) {
				pq.offer(temp.poll());
			}			
		}		
	}	
}
