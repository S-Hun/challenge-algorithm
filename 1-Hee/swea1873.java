package algos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드v2  {
	
	static char[][] maps;
	static final char[] tankWay = {'^', 'v', '<', '>'};
	static int TankR, TankC;
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		System.setIn(new FileInputStream("data/sw1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int orderLength = 0;
		int T = Integer.parseInt(br.readLine());
		int Row, Col;
		String line = "", order = "";
		
		for(int t = 1 ; t <= T ; t++) {
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			Row = Integer.parseInt(st.nextToken());
			Col = Integer.parseInt(st.nextToken());
			
			maps = new char[Row][Col];
			
			for(int r = 0 ; r < Row ; r++ ) {
				line = br.readLine();
				for(int c = 0 ; c < Col ; c++) {
					maps[r][c] = line.charAt(c);
					if("^v<>".indexOf(maps[r][c])!=-1) {
						TankR = r;
						TankC = c;
					}
				}
			}
						
			orderLength = Integer.parseInt(br.readLine());
			order = br.readLine();
			
			for(int i = 0 ; i < orderLength; i++) {
				if(order.charAt(i) != 'S') TankMove(order.charAt(i));
				else TankShoot(maps[TankR][TankC]);								
			}
			
			printMaps();
			
		}
		System.out.println(sb.toString());
	}
	
	static void printMaps() {
		
		for(int r = 0 ; r < maps.length; r++) {
			for(int c = 0 ; c < maps[r].length; c++) {
				sb.append(maps[r][c]);
			}
			sb.append("\n");
		}
	}
	
	static void TankMove(char order) {
		
		int direction = "UDLR".indexOf(order);
		maps[TankR][TankC] = tankWay[direction];
		
		int moveR = TankR + dx[direction];
		int moveC = TankC + dy[direction];

		
		if(moveR >= 0 && moveC >= 0 && moveR < maps.length && moveC < maps[0].length 
				&& maps[moveR][moveC] != '-' && maps[moveR][moveC] != '#' && maps[moveR][moveC]!='*') {			

			maps[moveR][moveC] = tankWay[direction];
			maps[TankR][TankC] = '.';
			TankR = moveR;
			TankC = moveC;			
			
		}
		
		

				
	}
			
	
	static void TankShoot(char order) {
		
		int direction = "^v<>".indexOf(order);
		
		int bulletR = TankR;
		int bulletC = TankC;
		
		while(true) {
			
			bulletR += dx[direction];
			bulletC += dy[direction];
			
			if(bulletR < 0 || bulletC < 0 
					|| bulletR > maps.length-1 || bulletC > maps[0].length-1) break;
			
			if(maps[bulletR][bulletC] == '#') break;
			
			if(maps[bulletR][bulletC] == '*') {
				maps[bulletR][bulletC] = '.';
				break;
			}
						
			if(maps[bulletR][bulletC] == '-') continue;
			else maps[bulletR][bulletC] = '.';

		}
		
		
	}

}
