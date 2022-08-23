package bakjoon2;

import java.util.ArrayList;
import java.util.Scanner;

public class bj1157_al_step6_5 {

	public static void main(String[] args) {

		// add 주석
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		ArrayList arr = new ArrayList<String>();
		input = input.toUpperCase();
		
		if(input.length()>1) {
						
			for(int i = 0 ; i < input.length() ; i++) {
				if(!arr.contains(input.charAt(i))) {
					arr.add(input.charAt(i));
				}			
			}
			
			int[][] point = new int[arr.size()][2];
			
			for(int i = 0 ; i < input.length() ; i++) {			
				for(int j = 0 ; j < arr.size() ; j++) {
					if(arr.get(j).equals(input.charAt(i))) {
						point[j][0]=j;
						point[j][1]++;
					}			
				}
			}
			
			int ins, cmp, temp, idx;

	        for(ins=1 ; ins < point.length ; ins++) {
	        	temp = point[ins][1];
	        	idx = point[ins][0];
	        	for(cmp = ins-1; cmp >=0 ; cmp--) {        		
	        		if(point[cmp][1]<temp) {
	        			point[cmp+1][1] = point[cmp][1];
	        			point[cmp+1][0] = point[cmp][0];
	        		} else {
	        			break;        			
	        		}
	        	}point[cmp+1][1]= temp; 
	        	 point[cmp+1][0]= idx;        	
	        }
	        
	        if(point[0][1]==point[1][1]) {
	        	System.out.println("?");
	        } else {
	        	System.out.println(arr.get(point[0][0]).toString().toUpperCase());
	        }
  			
		} else {
			System.out.println(input.toUpperCase());
		}
		


	}

}
