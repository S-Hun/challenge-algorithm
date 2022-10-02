package test;

import java.util.*;

public class bakjoon3052_al_step4_4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] input = new int[10];
		ArrayList Arr = new ArrayList<>();
		
		for(int i = 0 ; i < 10 ; i++) {
			int temp = sc.nextInt();
			sc.nextLine();
			input[i]=temp;
		}
		
		for(int i = 0 ; i < input.length ;i++) {
			
			input[i] = input[i]%42;
			if(!Arr.contains(input[i])) {
				Arr.add(input[i]);
			}
		}
		
		int size = Arr.size();
		
		System.out.println(size);
		
		
		

	}

}
