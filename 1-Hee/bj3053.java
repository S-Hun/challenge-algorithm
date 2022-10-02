package test;

import java.util.Scanner;

public class bj3053_al_step8_10 {
	
	public static double EuclideCircleArea(int n){
		
		double r = n;				
		double answer = Math.PI*r*r;
		
		return answer;		
	}
	
	public static double TaxiCircleArea(int n) {
		/*
		double r = n;
		double side = Math.sqrt(r*r+r*r);
		return side*side;
		
		// 유클리드 기하학에서는 주석처리한 내용의 코드와 같이 거리를 구하는데,
		// 맨해튼거리(택시기하학)에서는 다른 방법으로 원의 넓이를 구해야함.
		// 맨해튼 거리에서의 원의 넓이 = 2r*r;
		
		*/ 
		
		double area = 2*n*n;
		return area;
	}
	

	public static void main(String[] args) {
		// 유클리드 기하학의 원의 넓이 = 2파이r
		// 택시 기하학에서의 원의 넓이 = 비유클리드 기하학 
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();		
		
		System.out.println(String.format("%.6f", EuclideCircleArea(n)));
		System.out.println(String.format("%.6f", TaxiCircleArea(n)));

	}

}
