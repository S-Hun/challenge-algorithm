package bakjoon2;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj10757_al_step7_8 {

	public static void main(String[] args) {
		// 9223372036854775807 9223372036854775808
		
		
		// 자바에서는 unsigend long을 지원하지 않는다.
		// 대신 long 범위를 넘어가는 경우에은 Math 라이브러리에서 BigInteger라는 메서드를 지원하는데,
		// 이 메서드는 값을 숫자형(Int, Float, long..)이 아닌 문자형(String)으로 저장한다.
		// 따라서 int나 long의 사칙연산처럼 사칙연산자로 연산이 불가하며,
		// 해당 라이브러리에서 제공하는 사칙연산 메서드(add 등)을 사용해야한다.
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		StringTokenizer st = new StringTokenizer(input);
				
		String n1 = st.nextToken();
		String n2 = st.nextToken();
		
		BigInteger bi1 = new BigInteger(n1);
		BigInteger bi2 = new BigInteger(n2);
		
		System.out.println(bi1.add(bi2));				

	}

}
