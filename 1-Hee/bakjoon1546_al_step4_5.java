package test;

import java.util.*;

public class bakjoon1546_al_step4_5 {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		double[] Arr = new double[num];
		String str = sc.nextLine();		
		
		StringTokenizer st = new StringTokenizer(str);
		
		for(int i= 0 ; i < Arr.length ; i++) {
			Arr[i] = Double.valueOf(st.nextToken());
		}
		
		Arrays.sort(Arr);
		
		double sum = 0;
		
		for(int i = 0 ; i < Arr.length; i++) {
			
			if(Arr[i]>0) {
				Arr[i]= (Arr[i] / Arr[Arr.length-1])*100;		
			}
		
		}
		for(int i = 0 ; i < Arr.length ; i++) sum+=Arr[i];
		double answer = sum/num;		
		
		System.out.println(answer);
		
		
		

	}

}
