package algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_배열돌리기3 {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] maps = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		int orderTimes = Integer.parseInt(st.nextToken());
		
		for(int r = 0 ; r < maps.length; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < maps[r].length; c++) {
				maps[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < orderTimes; i ++) {
		
			switch(Integer.parseInt(st.nextToken())) {
				case 1:
					maps = func1(maps);
					break;
				case 2:
					maps = func2(maps);
					break;
				case 3:
					maps = func3(maps);
					break;
				case 4:
					maps = func4(maps);
					break;
				case 5:
					maps = func5(maps);
					break;
				case 6:
					maps = func6(maps);
					break;
				
			}
		}
		
		for(int r = 0 ; r < maps.length; r++) {
			for(int c = 0 ; c < maps[r].length; c++) {
				System.out.print(maps[r][c]+" ");
			}
			System.out.println();
		}
		
	}
	
	static int[][] func1(int [][] maps){
		int[][] result = new int[maps.length][maps[0].length];
		
		for(int i = 0 ; i < maps.length; i++) {
			int r = maps.length-1-i;			
			for(int j = 0 ; j < maps[i].length; j++) {
				result[i][j] = maps[r][j];
			}
		}		
		
		return result;
		
	}
	
	static int[][] func2(int [][] maps){
		int[][] result = new int[maps.length][maps[0].length];
		
		for(int i = 0 ; i < maps.length; i++) {			
			
			for(int j = 0 ; j < maps[i].length; j++) {
				int c = maps[i].length-1-j;
				result[i][j] = maps[i][c];
			}
		}		
		
		return result;		
	}
	
	static int[][] func3(int [][] maps){

		int[][] result = new int[maps[0].length][maps.length];
		
		for(int r = 0 ; r < result.length; r++) {
			for(int c = 0 ; c < result[r].length; c++) {
				result[r][c] = maps[maps.length-1-c][r];
			}
		}
		
		
		return result;		
	}
	
	static int[][] func4(int [][] maps){

		int[][] result = new int[maps[0].length][maps.length];
				
		for(int r = 0 ; r < result.length; r++) {
			for(int c = 0 ; c < result[r].length; c++) {
				result[result.length-1-r][c] = maps[c][r];
			}
		}
						
		return result;		
		
	}
	
	static int[][] func5(int [][] maps){

		int[][] result = new int[maps.length][maps[0].length];

		int N = maps.length;
		int M = maps[0].length;
		int gapR = N/2;
		int gapC = M/2;
		
		// 1 >> 2		
		for(int r = 0 ; r < N/2; r++) {
			for(int c = 0 ; c < M/2; c++) {
				result[r][c+gapC] = maps[r][c];
			}
		}
		
		// 2 >> 3
		for(int r = 0 ; r < N/2; r++) {
			for(int c = M/2 ; c < M; c++) {
				result[r+gapR][c] = maps[r][c];
			}
		}

		// 3 >> 4
		for(int r = N/2; r < N; r++) {
			for(int c = M/2; c < M; c++) {
				result[r][c-gapC] = maps[r][c];
			}
		}
		
		// 4 >> 1
		for(int r = N/2 ; r < N; r++) {
			for(int c = 0 ; c < M/2; c++) {
				result[r-gapR][c] = maps[r][c];

			}
		}
				
		return result;
	}
		
	static int[][] func6(int [][] maps){

		int[][] result = new int[maps.length][maps[0].length];

		int N = maps.length;
		int M = maps[0].length;
		int gapR = N/2;
		int gapC = M/2;
		
		// 1 >> 4	
		for(int r = 0 ; r < N/2; r++) {
			for(int c = 0 ; c < M/2; c++) {
				result[r+gapR][c] = maps[r][c];
			}
		}
				
		// 4 >> 3
		for(int r = N/2 ; r < N; r++) {
			for(int c = 0 ; c < M/2; c++) {
				result[r][c+gapC] = maps[r][c];

			}
		}
		
		// 3 >> 2
		for(int r = N/2; r < N; r++) {
			for(int c = M/2; c < M; c++) {
				result[r-gapR][c] = maps[r][c];
			}
		}

		
		// 2 >> 1
		for(int r = 0 ; r < N/2; r++) {
			for(int c = M/2 ; c < M; c++) {
				result[r][c-gapC] = maps[r][c];
			}
		}

				
		return result;
	}



}
