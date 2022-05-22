package bakjoon2;

import java.util.Scanner;

public class bj2775_al_step7_6 {

	public static int[][] apartNumbers = new int[15][14];
	
	public static void inputNumbers() {
		for(int i = 0 ; i < apartNumbers.length; i++) {
			for(int j = 0 ; j < apartNumbers[i].length ; j ++) {
				if(i==0) {
					apartNumbers[i][j] = j+1;
				} else if (j==0) {
					apartNumbers[i][j] = apartNumbers[i-1][j];					
				} else {
					apartNumbers[i][j] = apartNumbers[i][j-1] + apartNumbers[i-1][j];
				}				
			}
		}		
	}

	public static void main(String[] args) {
				
		inputNumbers();
						
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
				
		int[] answer = new int[n];
		
				
		for(int i = 0 ; i < n ; i ++) {
			int floor = sc.nextInt();
			sc.nextLine();
			int rooms = sc.nextInt();
			sc.nextLine();	
			
			answer[i] = apartNumbers[floor][rooms-1];
			
		}
		
		for(int i = 0 ; i < answer.length ; i ++) System.out.println(answer[i]);
		
		
	}

}
