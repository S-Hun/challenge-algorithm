package bakjoon2;

import java.util.Scanner;

public class bj2941_al_step6_9 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		
		String[] cr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i = 0 ; i < cr.length; i++) {
			if(input.contains(cr[i])) {
				input = input.replace(cr[i], "!");
			}			
		}
		
		System.out.println(input.length());

	}

}
