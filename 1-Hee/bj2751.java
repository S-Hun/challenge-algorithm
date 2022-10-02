import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sv5_2751 {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();		
		ArrayList<Integer> Numbers = new ArrayList<>(N);
		
		for(int i = 0 ; i < N ; i ++) {
			Numbers.add(sc.nextInt());
		}
		
		Collections.sort(Numbers);
		
		for(int value : Numbers) {
			sb.append(value).append("\n");			
		}
		System.out.println(sb);
		

	}	

}
