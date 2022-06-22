package solvedRanking;

import java.math.BigInteger;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

import java.math.BigInteger;
import java.util.Scanner;


public class bz5_1271 {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);		
		
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		
		System.out.println(a.divide(b));
		System.out.println(a.remainder(b));

	}

}
