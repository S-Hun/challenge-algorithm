package solvedRanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bz4_2845 {

	public static void main(String[] args) throws IOException {
		
		//String Builder
		
		/*
		 5 20
99 101 1000 0 97
-1 1 900 -100 -3
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] L1 = br.readLine().split(" ");
		String[] L2 = br.readLine().split(" ");
		
		int basic = Integer.parseInt(L1[0])*Integer.parseInt(L1[1]);
		
		StringBuilder sb = new StringBuilder();
		String result = "";
		
		for(int i = 0 ; i < L2.length; i ++) {
			
			int diff = Integer.parseInt(L2[i])-basic;
			sb.append(diff+" ");

		}
		
		System.out.println(sb.toString());
		
		
	}

}
