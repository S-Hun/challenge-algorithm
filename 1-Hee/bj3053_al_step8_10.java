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
		
		// ��Ŭ���� �����п����� �ּ�ó���� ������ �ڵ�� ���� �Ÿ��� ���ϴµ�,
		// ����ư�Ÿ�(�ýñ�����)������ �ٸ� ������� ���� ���̸� ���ؾ���.
		// ����ư �Ÿ������� ���� ���� = 2r*r;
		
		*/ 
		
		double area = 2*n*n;
		return area;
	}
	

	public static void main(String[] args) {
		// ��Ŭ���� �������� ���� ���� = 2����r
		// �ý� �����п����� ���� ���� = ����Ŭ���� ������ 
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();		
		
		System.out.println(String.format("%.6f", EuclideCircleArea(n)));
		System.out.println(String.format("%.6f", TaxiCircleArea(n)));

	}

}
