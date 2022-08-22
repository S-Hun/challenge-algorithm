package solvedRanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bz3_2857 {

	public static void main(String[] args) throws IOException {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] Codes = new String[5];
		ArrayList Agent = new ArrayList<>();
		
		for(int i = 0 ; i < 5 ; i ++) {
			Codes[i] = br.readLine();
			if(Codes[i].contains("FBI")) Agent.add(i+1);			
		}
		
		if(Agent.size()>0) {
			for(int i = 0 ; i < Agent.size(); i ++) {
				if(i==0) {
					System.out.print(Agent.get(i));				
				}else {
					System.out.print(" " + Agent.get(i));
				}
			}
		} else {
			System.out.print("HE GOT AWAY!");
		}
	}
}
