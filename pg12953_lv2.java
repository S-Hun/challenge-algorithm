package test;

import java.util.*;

public class pg12953_lv2 {

	public static void main(String[] args) {
		
		int[] arr = {3,4,9,16};
		ArrayList nums = new ArrayList<>();		
		Arrays.sort(arr);
				
		for(int i = 0 ; i < arr.length ; i++) {
			boolean usage = false;
			
			if(arr[i]>1) {
				for(int j = 0 ; j< arr.length ; j++) {
					if(j!=i && arr[j]%arr[i]==0) {
						arr[j] /= arr[i];
						usage=true;
					}											
				}
			}
			
			
			
			if(usage) {
				nums.add(arr[i]);
			}else {				
				nums.add(arr[i]);
				arr[i]/=arr[i];
			}
		}
		
		int answer = 1; 
		for(int i = 0 ; i < nums.size() ;i++) {
			answer *= (int) nums.get(i);
		}

		System.out.println(answer);
	}

}

class Solution {
    public static int solution(int[] arr) {
	      int lcm1 = arr[0];
	      for(int i=0;i<arr.length;i++) {	    	  
	    		  lcm1 =lcm(lcm1,arr[i]);	    	  
	      }
	      return lcm1;
	  }
      		 
	 static int gcd(int a, int b) {
		 while(b!=0) {
			 int r=a%b;
			 a=b;
			 b=r;
		 }
		 return a;
	 }
	 static int lcm(int a,int b) {
		 return a*b/gcd(a,b);
	 }
}

class Solution2 {
    public static int solution(int[] arr) {
    	int lcm1 = arr[0];
    	for( int i = 0 ; i < arr.length; i++) {
    		lcm1 = lcm(lcm1, arr[i]);
    	}
    	
    	return lcm1;
    	
    	    	
	  }
    
      static int gcd(int a, int b) {
    	  while(b!=0) {
    		  int r = a%b;
    		  a=b;
    		  b=r;
    	  }
    	  return a;
      }
      static int lcm(int a, int b) {
    	  return a*b/gcd(a,b);
      }
      		 
}




