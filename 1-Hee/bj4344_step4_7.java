package test;

import java.util.*;

public class bj4344_step4_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.nextLine();
		double[] Ratio = new double[num];
		String[] Input = new String[num];
		
		for(int i = 0 ; i < num ; i++) {
			Input[i] = sc.nextLine();			
		}
		
		for(int i = 0 ; i < Input.length ; i++) {
			StringTokenizer st = new StringTokenizer(Input[i]);
			int len = Integer.valueOf(st.nextToken());
			int[] temp = new int[len];
			int count=0; 
			double sum= 0;
					
			for(int j = 0 ; j < len ; j++) {
				temp[j] = Integer.valueOf(st.nextToken());
				sum+=temp[j];
			}
			
			double avg = sum/len;
			
			for(int k = 0 ; k < temp.length ; k++) {
				if(temp[k]>avg) {
					count++;
				}
			}
			Ratio[i] = ((double) count/(double) len)*100;
			System.out.println(String.format("%.3f", Ratio[i])+"%");
			
		}
		
		
	}

}
