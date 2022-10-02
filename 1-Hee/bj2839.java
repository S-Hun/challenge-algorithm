package bakjoon2;

import java.util.Scanner;

public class bj2839_al_step7_7 {
	
	
	public static int MinSugar(int n){
		int max, min, temp = 0;		
		
		if(n%3!=0) max = -1; else max = n/3;
		if(n%5!=0) min = -1; else {
			min = n/5; 
			return min;
		}
		
		
		for(int i =1 ; i < n/3 ; i ++) {
			int s1 = i;
			int s2;

			int value1 = n-5*i;
			
			if(value1<0) break;

			if(value1%3 ==0) {
				s2 = value1/3;
				if(temp ==0) {
					temp = s1+s2;
				} else {
					if(temp>s1+s2) {
						temp = s1+s2;
					}
				}				
			} else {
				continue;
			}				
		}
		
		if(temp == 0) temp = -1;
		
		if(temp==-1&&max!=-1) return max;
		else if(temp!=-1&&max==-1) return temp;
		else if(temp!=-1&&max!=-1) {
			if(temp<max) return temp; else return max;
		}else {
			return -1;
		}
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println(MinSugar(n));
				
	}

}
