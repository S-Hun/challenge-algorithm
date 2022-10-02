package solvedRanking;

import java.math.BigInteger;
import java.util.Scanner;

public class bz5_2338 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A×B를 출력한
		
		// 1
		// -1
		
		Scanner sc = new Scanner(System.in);
		
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));


		


	}

}
