package bakjoon2;

import java.util.Scanner;

public class bj3009_al_step8_8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		String st1 = sc.nextLine();
		String st2 = sc.nextLine();
		String st3 = sc.nextLine();
		
		String X, Y;
		
		String[] point1 = st1.split(" ");
		String[] point2 = st2.split(" ");
		String[] point3 = st3.split(" ");
		
		if(point1[0].equals(point2[0])) {
			X = point3[0];
		} else if (point1[0].equals(point3[0])) {
			X =point2[0];
		} else {
			X = point1[0];
		}
		
		if(point1[1].equals(point2[1])) {
			Y = point3[1];
		} else if (point1[1].equals(point3[1])) {
			Y =point2[1];
		} else {
			Y = point1[1];
		}
		
		System.out.println(X+" "+Y);

	}

}
