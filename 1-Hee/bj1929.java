package bakjoon2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1929_al_step8_4 {
	
	public static int[] PrimeRange(int m, int n) {
		
		// 주어진 범위 내의 소수의 개수는 가변적이어서 이를 임시로 담아둘 배열을 생성
		ArrayList PrimeArr = new ArrayList<>();
		
		for(int x = m ; x<=n ; x++) {
			// 수학적 정의에 따라 1은 소수가 아니므로 제외하고,
			if(x==1) continue;
			// 2부터 소수일 수 있는데 3까지는 무조건 소수이므로 
			// 주어진 숫자가 2나 3일 경우 배열에 바로 넣고 신속하게 반복문을 재개함.
			else if (x==2) {
				PrimeArr.add(x);
				continue;
			}
			else if (x==3) {
				PrimeArr.add(x);
				continue;			
			}
			else {
				// 4이상의 숫자에 대한 소수 판별을 위한 알고리즘
				boolean check = false;
				for(int i =2 ; i*i <=x; i++) {
					if(x%i==0) {
						check = false; 
						break;				
					}else {
						check = true;
					}
				}
				if(check==true) {
					PrimeArr.add(x);
				} else continue;			
			}		
		}
		
		// 임시로 ArrayList에 담아둔 소수 값들을 배열에 옮겨 담음.
		int[] answer = new int[PrimeArr.size()];
		for(int i = 0 ; i< answer.length ; i++) {
			answer[i]=(int) PrimeArr.get(i);
		}
		return answer;
		
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		// 이번에는 StringTokenizer 말고 split을 이용해서 값을 나누어봄
		// 왜냐하면, 무조건 값은 공백으로 구분된 두가지 숫자이므로,
		String[] range = input.split(" ");
		
		// 혹시 값이 거꾸로 입력되었을 경우를 대비하여 대소관계를 비교하는 조건문
		int m, n;
		if(Integer.valueOf(range[0])<Integer.valueOf(range[1])) {
			m = Integer.valueOf(range[0]);
			n = Integer.valueOf(range[1]);
		} else {
			n = Integer.valueOf(range[0]);
			m = Integer.valueOf(range[1]);
		}

		
		int[] get = PrimeRange(m, n);
		for(int i = 0 ; i<get.length ; i++) System.out.println(get[i]); 
		

	}

}
