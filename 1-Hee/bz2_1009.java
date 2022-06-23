package solvedRanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class bz2_1009 {

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int times = Integer.parseInt(br.readLine());

		int[] answer = new int[times];
		
		for(int i = 0 ; i < times ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = 1;
			int under = Integer.parseInt(st.nextToken());
			int upper = Integer.parseInt(st.nextToken());
			
			for(int j = 0 ; j<upper ; j++) {
				r = under*r%10;
			}
			
	        if (r==0) r=10;
	        System.out.println(r);
	
		}
		

	}
}
