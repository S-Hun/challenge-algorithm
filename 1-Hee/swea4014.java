package com.swea.A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {

	static int N, X;
	static int[][] map, rmap;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/swea4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			rmap = new int[N][N];
			
			for(int i = 0 ; i < N ; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
				 	rmap[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i = 0 ; i < N ; i ++) {
				if(judgePossible(map[i]))cnt++;				
				if(judgePossible(rmap[i])) cnt++;				
			}
			sb.append(cnt).append("\n");						
		}
		System.out.println(sb.toString());
		
	}
	private static boolean judgePossible(int[] line) {
		
		int height = line[0];
		int cnt = 0;
		for(int i = 0 ; i < N ; i ++) {
			if(height==line[i]) cnt++;			
			// 오르막
			else if(line[i]==height+1) {
				if(cnt<X) return false;
				cnt=1;
				height++;				
			}else if(line[i]==height-1) {// 내리막
				cnt = 0;
				for(int j = i ; j < N ; j ++) {
					if(height != line[j]+1) return false;
					if(++cnt>=X) break;
				}
				if(cnt<X) return false;
				height--;
				cnt = 0;
				i+=X-1;				
			}else return false;
		}
				
		return true;
	}

}
