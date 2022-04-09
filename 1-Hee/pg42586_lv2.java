package test;

import java.util.*;

public class pg42586_lv2 {

	public static void main(String[] args) {
		
//		[93, 30, 55]	[1, 30, 5]	[2, 1]
//				[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
		//int[] progresses = {93, 30, 55};
		//int[] speeds = {1, 30, 5};
		int[] progresses = { 95, 90, 99, 99, 80, 99 }; 
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		
		
		ArrayList arr = new ArrayList<>();
		int count = 0;		
		
		for(int i = 0 ; i < progresses.length; i++) {
				while(progresses[i]<100) {
					for(int j = i ; j < progresses.length ; j++) {
						progresses[j] += speeds[j];
					}
				}
				
				
				if(i==count) {
					for(int k = count; k < progresses.length ; k++) {
						if(!(progresses[k]<100)) count++; else break;	
					}
					arr.add(count);					
				}
			
		}
		int[] answer = new int [arr.size()];
		
		for(int i = 0; i < arr.size(); i++) {
			if(i>0) {
				answer[i] = (int) arr.get(i) - (int) arr.get(i-1);
			} else {
				answer[i] = (int) arr.get(i);
			}
		}
		

	
		
		
		
		
		

	}

}

