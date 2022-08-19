package test;

import java.util.*;

public class bakjoon10818_al_step4_1{
    public static void main(String[] args){
    	
    	Scanner sc = new Scanner(System.in);

    	int n = sc.nextInt();
    	sc.nextLine();
    	String input = sc.nextLine();
        
    	int[] Arr = new int[n];    
    	StringTokenizer st = new StringTokenizer(input);
    	
    	for(int i =0 ; i < Arr.length ; i++) Arr[i] = Integer.valueOf(st.nextToken());
    	
    	Arrays.sort(Arr);
    	System.out.println(Arr[0]+" "+Arr[Arr.length-1]);
		
    	
    }
}

