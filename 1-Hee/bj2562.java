package test;

import java.util.*;

public class bakjoon2562_al_step4_2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] Arr = new int[9];
		
		for(int i=0 ; i <9 ; i++) {
			Arr[i] = sc.nextInt();
			sc.nextLine();
		}
		
		int temp = Arr[0];
		int pos = 0;
		for(int i =0 ; i <Arr.length ;i++) {
			if(temp < Arr[i]) {
				temp = Arr[i];
				pos=i;
			}
		}
		
		System.out.println(temp);
		System.out.println(pos+1);

	}

}
