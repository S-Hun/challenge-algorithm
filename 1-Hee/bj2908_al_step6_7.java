package bakjoon2;

import java.util.*;

public class bj2908_al_step6_7 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);		
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input);
		String[] compare = new String[st.countTokens()];
		
		for(int i = 0 ; i < compare.length ; i++) {
			String reverse = "";
			compare[i] = st.nextToken();
			for(int j = (compare[i].length()-1) ; j >= 0 ; j--) {
				reverse += compare[i].charAt(j);
			}
			compare[i] = reverse;
		}
		
		if(Integer.valueOf(compare[0])>Integer.valueOf(compare[1])) {
			System.out.println(Integer.valueOf(compare[0]));
		}else {
			System.out.println(Integer.valueOf(compare[1]));
		}
		

	}

}
