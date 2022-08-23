package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1002_al_step8_11 {
	
	public static int CalcCaseEnemy(int[] arr) {
		
		
		// 터렛 문제에서 가능한 경우의 수는 총 네가지이다.
		// 첫번째는, 
		// 두 터렛이 완전히 동일하여 x좌표, y좌표도 같고 반지름도 같은 경우. 
		// -> 이 때의 경우의 수는 무한대. 리턴 값은 -1;
		
		// 두번째는, 
		// 두원이 서로 다른 위치에 있고 어느 점에도 겹치지 않거나(r1+r2<d),
		// 큰원 속에 작은 원이 존재하고, 작은 원의 둘레가 큰원의 중심점을 지나지 않는 경우(r1-r2 >d)
		// -> 이때의 경우의 수는 존재하지 않음. 리턴 값은 0;
		
		
		// 세번째는,
		// 두 원이 서로 외부에서 한점만을 만나는 경우(r1+r2=d, (x1,y1)!=(x2,y2)) 또는,
		// 큰원 안에서 작은원이 내포되어 있으며, 작은원의 둘레가 큰원의 둘레와 한 점에서 만나는 경우
		// (작은원의 원주가 큰원의 중심점을 지남) (r1-r2 = d);
		// -> 이때의 경우의 수는 1가지, 리턴 값은 1;
		
		// 네번째는,
		// 두 원이 중심점을 서로 달리하고, 두점에서 만나는 경우
		// else로 처리해도 되지만, 
		// 확실한 이해를 위해 일반식으로 표현하면 (r1-r2) < d && (r1+r2) > d 인 경우
		// -> 이때의 경우의 수는 2가지, 리턴값은 2;
		
		double d = Math.sqrt(Math.pow(arr[0]-arr[3], 2)+Math.pow(arr[1]-arr[4], 2));
		
		if(arr[0]==arr[3] && arr[1]==arr[4] && arr[2]==arr[5]) {
			return -1;
		} else if(arr[2]+arr[5]<d || Math.abs(arr[2]-arr[5]) > d 
				|| (arr[0]==arr[3]&&arr[1]==arr[4]&&arr[2]!=arr[5])) {
			return 0;
		} else if(arr[2]+arr[5]==d || Math.abs(arr[2]-arr[5])==d) {
			return 1;
		} else {
			return 2;			
		}

		
	}
	

	public static void main(String[] args) {
		
		// 두원의 기하학적 위치에 관하여 경우의 수를 생각하는 문제.
		// 여기서 가장 중요한 값은 크게 두종류, 터렛의 반지름과 두 터렛사이의 거리
				
		
		int[] info = new int[6]; // 테스트케이스를 1회 입력받을때마다 값을 저장하고 처리하기 위해 만든 배열.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int[] answer = new int[n]; //값의 갯수는 테스트 케이스의 수에 의해 결정됨.

		
		for(int i = 0 ; i < n ; i ++) {
			String input = sc.nextLine(); // 한번에 값을 받기 위해, 우선 String 문자열로해서 값을 저장함.
			StringTokenizer st = new StringTokenizer(input);  // StringTokenizer로 문자열 값을 쪼갬.
			for(int j = 0 ; j < 6 ; j++) {
				info[j] = Integer.valueOf(st.nextToken()); // Integer.valueOf() 메서드로 형변환을 함.
			}
			
			answer[i]=CalcCaseEnemy(info); // 사용자 정의 함수 CalcCaseEnemy()로 경우의 수를 계산하고 바로 값을 배열에 저장함.									
		}
		
		for(int i = 0 ; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
		
		
		
		
		 

	}

}
