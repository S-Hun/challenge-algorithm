package solvedRanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bz5_2475 {

	public static void main(String[] args) throws IOException {
		
		
		// 0 4 2 5 6
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 String[] input = br.readLine().split(" ");
		 
		 int sum = (int) (Math.pow(Integer.parseInt(input[0]), 2)+Math.pow(Integer.parseInt(input[1]), 2)
		 +Math.pow(Integer.parseInt(input[2]), 2)+Math.pow(Integer.parseInt(input[3]), 2)+Math.pow(Integer.parseInt(input[4]), 2));
		 
		 System.out.println(sum%10);	

	}

}
