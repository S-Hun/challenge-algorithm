package bakjoon2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bj11653_al_step8_3 {
	
	public static int[] Factorization(int n) {
		
		ArrayList Members = new ArrayList<>();
		
		int[] Return = new int[1];
		
		switch(n) {
		case 1:
			Return[0]=1;
			return Return;
		case 2:
			Return[0]=2;
			return Return;
		case 3:
			Return[0]=3;
			return Return; // 3이하의 숫자는 무조건 소수이므로 소인수분해를 해도 자기자신만 나오므로 자기 자신을 리턴해줌
		default:
			int s; //소인수인 변수 값을 담을 s를 선언하고 for문에 증감식에 넣음
			for(s = 2 ; s*s<=n; s++) { // 소인수분해는 사실 소수찾기를 살짝 응용하면 해결하기 쉬운 문제
				if(n%s==0) { // 나눠지는 숫자는 소인수이므로 ArrayList에 값을 추가하여 소인수를 저장함. 
					Members.add(s);
					n/=s; // 입력값을 s로나누는 작업과 if문의 조건으로 인해 이 줄은 에라토네스 체의 원리가 구현됨.
					s--; // 이 줄을 보면 왜 에라토네스 체가 적용되는지 알수 있는데, 
						 // 예컨데 값이 증가하여 4가 되더라도 이미 2에서 계속 2로 나뉘면 나누어버렸기 때문에
						 // 2의 배수는 소인수로 들어갈수가 없음. 따라서 for문의 값이 증가할때, 소수만이 나눠질 경우 소인수가 될 수 있음.
				}				
			}
			if(n!=1) { 
				if(n%s==0) Members.add(s);
				else Members.add(n);
			}
			
			int[] answer = new int[Members.size()];
			
			for(int i = 0 ; i < Members.size() ; i++) {
				answer[i] = (int) Members.get(i);
			}
			return answer;
			//
		
		}
		
		
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		int[] get = Factorization(n); // 스캐너를 통해 값을 입력받고 새로 선언한 메서드 Factorization를 통해서 소인수를 구함.
		if(get[0]!=1) { // 문제에서 1이 입력되면 아무것도 입력하지 말란 조건때문에 여기 if문을 만듦
			// 함수 Factorization()에서 매개변수로 1을 입력하면 배열 크기가 1이고 배열 요소가 1인 배열을 리턴하므로 필터링 가능
			for(int i= 0 ; i < get.length; i++) System.out.println(get[i]);
		}
		
		

	}

}
