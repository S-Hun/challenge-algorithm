package com.java.j0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
		
	static class AirCleaner {
		private static int[] posX;
		private static int lastIdx;

		public AirCleaner() {
			posX = new int[2];
		}
		
		private static void add(int x) {
			if(lastIdx==2) return;
			posX[lastIdx] = x;
			lastIdx++;
		}
	}
	
	static int idx1, idx2;
	static int R, C;
	static int[][] rooms;
	static boolean[][] isVisited;
	static AirCleaner ac;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		
		rooms = new int[R][C];		
		ac = new AirCleaner();
		
		for(int i = 0 ; i < R ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C ; j ++) {
				rooms[i][j]	= Integer.parseInt(st.nextToken());
				if(rooms[i][j] == -1) ac.add(i); 
			}
		}
		
		
		for(int i = 0 ; i < T ; i ++) {
			spreadDust();
			
		}
//		printMaps();
		System.out.println(sumRoom());
				
	}
	
	
	private static void spreadDust() {
		
		int [] dx = {-1, 1, 0, 0};
		int [] dy = {0, 0, -1, 1};
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		for(int i = 0 ; i < R ; i ++) {
			for(int j = 0 ; j < C ; j ++) {
				if(rooms[i][j] > 0) q.offer(new int[] {i, j, rooms[i][j]});
			}
		}
		
		while(!q.isEmpty()) {
					
			
			for(int t = 0 ; t < q.size(); t++) {				
				int [] cur = q.poll();
				
				for(int i = 0 ; i < 4 ; i ++) {
					int dr = cur[0] + dx[i];
					int dc = cur[1] + dy[i];
					
					if(dr < 0 || dc < 0 || dr >= R || dc >= C || rooms[dr][dc] == -1 || cur[2] < 5) continue;			
					rooms[dr][dc] += cur[2]/5;					
					rooms[cur[0]][cur[1]] -= cur[2]/5;					
				}				
			}			
		}
		blow2();

		
		
		
	}



	private static void printMaps() {
		for(int i = 0 ; i < R ; i ++) {
			for(int j = 0 ; j < C ; j ++) {
				if(rooms[i][j]==-1) System.out.print("뿝"+" ");
				else System.out.print(rooms[i][j]+" ");
			}
			System.out.println();
		}
	}

	
	private static void blow2() {
		
		int top = ac.posX[0]-1;
		
		for(int r = top ; r > 0 ; r --) {
			rooms[r][0] = rooms[r-1][0];
		}
		for(int c = 0 ; c < C-1 ; c++) {
			rooms[0][c] = rooms[0][c+1];
		}
		
		for(int r = 0 ; r <= top ; r++) {
			rooms[r][C-1] = rooms[r+1][C-1];
		}
		
		for(int c = C-1; c > 1 ; c--) {
			rooms[ac.posX[0]][c] = rooms[ac.posX[0]][c-1];
		}
						
		rooms[ac.posX[0]][1] = 0;
		
		top = ac.posX[1]+1;
		for(int r = top ; r < R-1 ; r ++) {
			rooms[r][0] = rooms[r+1][0];
		}
		
		for(int c = 0 ; c < C-1 ; c++) {
			rooms[R-1][c] = rooms[R-1][c+1];
		}
		
		
		for(int r = R-1 ; r >= top ; r--) {
			rooms[r][C-1] = rooms[r-1][C-1];
		}
		
		for(int c = C-1; c > 1 ; c--) {
			rooms[ac.posX[1]][c] = rooms[ac.posX[1]][c-1];
		}
						
		rooms[ac.posX[1]][1] = 0;		
		
	}
	
	
	
	private static void pushingAir(int x, int y, boolean mode) {
		
		int[] dx1 = {0, -1, 0, 1};
		int[] dy1 = {1, 0, -1, 0};
		
		int[] dx2 = {0, 1, 0, -1};
		int[] dy2 = {1, 0, -1, 0};
		
		if(mode) {
			
			int minX = x;
			int minY = y;
			int maxX = R-1;
			int maxY = C-1;			
			
			int val = rooms[minX][minY]; //(c,c)
			
			for(int j=minX+1; j<maxX; j++) //왼쪽
				rooms[j][minY] = rooms[j+1][minY];
			
			for(int j=minY; j<maxY; j++) //아래쪽
				rooms[maxX][j] = rooms[maxX][j+1];
			
			for(int j=maxX; j>minX; j--) //오른쪽
				rooms[j][maxY] = rooms[j-1][maxY];
			
			for(int j=maxY; j>minY; j--) //위쪽
				rooms[minX][j] = rooms[minX][j-1];
			
			rooms[minX][minY+1] = val;
			rooms[minX][minY] = -1;						

			
		}else {
			
			
		}
				
	}

	private static int sumRoom() {
		int result = 0;
		
		for(int i = 0 ; i < R; i ++) {
			for(int j = 0 ; j < C; j ++) {
				if(rooms[i][j]>0) result += rooms[i][j];
			}
		}
		
		return result;
	}
	
	
	
}
