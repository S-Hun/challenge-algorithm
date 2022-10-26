package com.swea.A;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {
	
	static int N;
	static LinkedList<Integer>[] magnetics;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/swea4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			N = Integer.parseInt(br.readLine());
			magnetics = new LinkedList[4];
			for(int i = 0 ; i < 4 ; i++) 
				magnetics[i] = new LinkedList<Integer>();
			
			for(int i = 0 ; i < 4 ; i ++) {
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens())
					magnetics[i].add(Integer.parseInt(st.nextToken()));				
			}
			
			for(int k = 0 ; k < N ; k ++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken())-1;
				int dir = Integer.parseInt(st.nextToken());
				rotate(idx, dir, new boolean[4]);				
			}
			
			int result = 0;
			for(int i = 0 ; i < 4 ; i ++) {
				if(magnetics[i].get(0)==1) {
					result += Math.pow(2, i);
				}
			}
			sb.append(result).append("\n");
						
		}
		System.out.println(sb.toString());
	}
	private static void rotate(int idx, int d, boolean[] isSpined) {
		
		switch(d) {
			case 1:
				isSpined[idx] = true;
				if(idx-1 >= 0 && !isSpined[idx-1] && magnetics[idx].get(6)!=magnetics[idx-1].get(2)) rotate(idx-1, -1, isSpined);
				if(idx+1 < 4 && !isSpined[idx+1] && magnetics[idx].get(2)!=magnetics[idx+1].get(6)) rotate(idx+1, -1, isSpined);
				magnetics[idx].addFirst(magnetics[idx].removeLast());
				break;
			case -1:
				isSpined[idx] = true;
				if(idx-1 >= 0 && !isSpined[idx-1] && magnetics[idx].get(6)!=magnetics[idx-1].get(2)) rotate(idx-1, 1, isSpined);
				if(idx+1 < 4 && !isSpined[idx+1] && magnetics[idx].get(2)!=magnetics[idx+1].get(6)) rotate(idx+1, 1, isSpined);				
				magnetics[idx].addLast(magnetics[idx].removeFirst());
				break;
		}
		
	}
	

}
