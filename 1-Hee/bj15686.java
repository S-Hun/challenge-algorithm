package com.ssafy.java.off0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Nodes{
	int X;
	int Y;
	
	public Nodes(int x, int y) {
		super();
		X = x;
		Y = y;
	}
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
}

public class BOJ_15686_치킨배달 {
	
	static int [][] maps;
	
	static int MIN = Integer.MAX_VALUE;
	static int CN, M;
	static int[] numbers, inputs;
	
	static List<Nodes> Homes, chickenShop;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// X는 치킨집 수 XCM
		
		maps = new int[N][N];
		
		Homes = new ArrayList<Nodes>();
		chickenShop = new ArrayList<Nodes>();
		
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				
				if(maps[i][j] == 1) Homes.add(new Nodes(i, j));								
				if(maps[i][j] == 2) chickenShop.add(new Nodes(i, j));
				
			}
		}
		
		CN = chickenShop.size();
		
		inputs = new int[chickenShop.size()];
		for(int i = 0 ; i < inputs.length; i ++) {
			inputs[i] = i;
		}
		
		numbers = new int[M];		
		comb(0, 0);		
		System.out.println(MIN);						
		
	}
	
	private static int CalcChickLength(int[] position) {
		
		int [] HomeChickenLength = new int[Homes.size()];
		Arrays.fill(HomeChickenLength, Integer.MAX_VALUE);
		
		for(int i = 0 ; i < position.length; i ++) {					
			for(int j = 0 ; j < HomeChickenLength.length; j++) {

				int distance = Math.abs(chickenShop.get(position[i]).getX() - Homes.get(j).getX())
						+ Math.abs(chickenShop.get(position[i]).getY() - Homes.get(j).getY());
				
				HomeChickenLength[j] = Math.min(HomeChickenLength[j], distance);
			}
		}		
		
		int sum = 0;
		for (int i = 0 ; i < HomeChickenLength.length; i++) {
			sum += HomeChickenLength[i];				
		}
		return sum;
	}
	
	
	private static void comb(int cnt, int start) {
		
		if(cnt == M) {			
			MIN = Math.min(MIN, CalcChickLength(numbers));			
			return;
		}
		
		for(int i = start; i < CN ; i++) {			
			numbers[cnt] = inputs[i];
			comb(cnt+1, i+1);			
		}
		
	}

}
