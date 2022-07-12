package solvedRanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sv5_1417 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int Dasom = Integer.parseInt(br.readLine());
							
		int[] Numbers = new int[N-1];
				
		for(int i = 0 ; i < N-1 ; i ++) {
			Numbers[i] = Integer.parseInt(br.readLine());
		}
		
		
		if(N==1) {  // 배열이 다솜 혼자인 경우 
			System.out.println("0");
			return;
		}
		
		int people = 0;
		
		// Dasom의 
		
		while(true) {
			Arrays.sort(Numbers);
			int last = Numbers.length-1;
			boolean check = true;
			if(Dasom<=Numbers[last]) {
				Dasom++;
				Numbers[last]--;
				people++;
				check = false;
			}
			
			if(check) break;			
		}
		
		System.out.println(people);		

	}

}
