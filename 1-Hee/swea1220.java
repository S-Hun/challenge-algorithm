package boj.problem.p0803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1220_SW문제해결_기본_5일차_Magnetic {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		System.setIn(new FileInputStream("data/sw1220.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int t = 1; t <= 10 ; t ++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			
			int [][] tables = new int[N][N];
			
			for(int i = 0 ; i < N ; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j ++) {
					tables[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int total = 0;
			
			for(int c = 0 ; c < N ; c ++) {
				
				int r = 0;
				int cnt = 0;
				boolean check = false;			
				
				while(r < N) {
													
					if(tables[r][c]==1) {
						check = true;
						
						while(check && r < N) {
							if(tables[r][c] != 2) {
								r++;
							}else {
								cnt++;
								check = false;
							}
						}
						
					}
					
					r++;				
				}
				total += cnt;
			}
			
			System.out.println("#"+t+" "+total);
			
		}
		
		
		
		
		


	}

}
