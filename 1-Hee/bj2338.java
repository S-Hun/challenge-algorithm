package solvedRanking;

import java.math.BigInteger;
import java.util.Scanner;

public class bz5_2338 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ù° �ٿ� A+B, ��° �ٿ� A-B, ��° �ٿ� A��B�� �����
		
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
