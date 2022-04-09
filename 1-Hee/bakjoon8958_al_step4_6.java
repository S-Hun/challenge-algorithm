package test;

import java.util.*;

public class bakjoon8958_al_step4_6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		
		String[] Input = new String[num];
		int[] point = new int[Input.length];
				
		int count = 0;
		int sum = 0;
		
		for(int i = 0 ; i < num ; i++) {
			Input[i] = sc.nextLine();
		}
		for(int i = 0 ; i < Input.length; i++) {
			int[] temp = new int[Input[i].length()];
			for(int j = 0 ; j < Input[i].length() ; j++) {
				if(Input[i].charAt(j)=='O') {
					count++;
					temp[j]= count;
					if(j==Input[i].length()-1) count=0;
				} else if (Input[i].charAt(j)=='X') {
					count=0;
					temp[j] = count;
				}
				
			}
			for(int k = 0 ; k < temp.length ; k++) sum += temp[k];			
			Arrays.fill(temp, 0);
			point[i] = sum;
			sum=0;
		}
				
		for(int i = 0 ; i < point.length; i++) System.out.println(point[i]);
		

	}

}
