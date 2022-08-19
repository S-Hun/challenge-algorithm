package bakjoon2;

import java.util.Scanner;

public class bj1193_al_step7_3 {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
		
			// 구하고 싶은 값의 순번인 x를 구한다, 여기서 14를 입력하면 14번째 요소를 구하는 것.
			int x = sc.nextInt();
			int sum = 1; // 입력한 숫자가 몇번째 대각선 배열에 위치하는지 판정하기 위해 임시로 값을 세팅함.
			int line = 1; // 가장 첫번째 요소를 1번째 대각선, line=1로 정의함.
			
			while(x>sum) {
				line++;
				sum+=line;
				// 반복문과 등차수열의 원리를 응용하여, 입력한 숫자의 대각선 값이 얼만지 판정할 수 있음.
			}
			int index = line - (sum-x); 
			// 입력한 숫자가 해당 대각선의 몇번째에 해당하는지 판정하기 위한 일반식
			// 배열 속 숫자의 배치는 지그재그로 설정되었지만, 입력될 숫자를 셈하는 것은 선형으로 하기 때문에 해당 일반식이 성립될 수 있음.
		
			
			int left =0;
			int right =0;
			
			// 배열속 분수의 분자를 left라 하고, 분모를 right라 했을 때,
			// line이 짝수이면 해당 대각선 내에서 값이 1부터 증가하고, right가 line부터 감소함.
			// line이 홀수이면 해당 대각선 내에서 값이 line부터 감소하고, right가 1부터 증가함.
			// 이를 아래의 코드로 구현.
			
			
			if(line%2==0) {
				left=1;
				right=line;
				for(int i = 1 ; i<index; i++) {
					left++;
					right--;				
				}
				
			} else {
				left=line;
				right=1;
				for(int i = 1 ; i<index; i++) {
					left--;
					right++;
				}						
			}
					
			System.out.println(left+"/"+right);
			
	}

}
