package test;

import java.util.*;

public class bakjoon10951_al_step3_13 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList Arr = new ArrayList<>();
		
			
		while(sc.hasNext()) { // 문제에서 입력의 끝을 명시하지 않았으므로 EOF 방식으로 값을 계속 입력 받아야 함.
			String input = sc.nextLine();
			StringTokenizer st = new StringTokenizer(input);
			int st1 = Integer.valueOf(st.nextToken());
			int st2 = Integer.valueOf(st.nextToken());
			if((st1!=0 && st1<10)&&(st2!=0 && st2<10)) {
				Arr.add(st1+st2); // 값을 입력받아 계산된 결과를 계속해서 배열에 입력
			}
		}
		
		for(int i = 0 ; i < Arr.size() ; i++) {
			System.out.println(Arr.get(i));
		}
		

		
		
		

	}

}
