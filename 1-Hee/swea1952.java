package com.swea.A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {
	
	// 10분

	private static int[] prices;
	private static int[] usage;
	private static int min;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/swea1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1 ; t<=T; t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			prices = new int[4];
			usage = new int[12];
			
			for(int i = 0 ; i < 4; i++) 
				prices[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < 12 ; i ++)
				usage[i] = Integer.parseInt(st.nextToken());
			
			min = prices[3];
			
			dfs(0, 0);
			sb.append(min).append("\n");
			
		}
		System.out.println(sb.toString());
		
	}
	private static void dfs(int idx, int sum) {
		if(sum >= min) return;
		if(idx >= 12) {
			min = Math.min(min, sum);
			return;
		}
		if(usage[idx]==0) {
			dfs(idx+1, sum);
		}
		dfs(idx+1, sum+prices[0]*usage[idx]);
		dfs(idx+1, sum+prices[1]);
		dfs(idx+3, sum+prices[2]);
		
		
	}


}
