package bakjoon2;

import java.util.*;

public class bj10809_al_step6_3 {

	public static void main(String[] args) {
		// 97 ~ 122
		
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		sc.nextLine();
		
		String answer = "";
		int pos = 0;

		for(int i = 97 ; i <123 ; i++) {
			for(int j = 0 ; j < st.length() ; j++) {
				if(i == (int) st.charAt(j)) {
					pos = j;
					break;
				} else {pos =-1;
				
				}
			}
			answer += pos + " ";
		}
		
		System.out.println(answer);
		
		

	}

}
