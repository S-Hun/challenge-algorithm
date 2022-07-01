import java.util.Arrays;
import java.util.Scanner;

public class sea_d1_2063 {

	public static void main(String[] args) {

		// 통계학 개념인 중앙값 = 중위수를 구하는 문제,
		// 배열을 정리하고 그 배열의 가운데 값을 구하면 되는 문제,
		// 그런데 입력 값은 정렬되지 않은 날것의 데이터이므로 정렬이 필요.
		// 정렬은 java 라이브러리에서 제공하는 Arrays.sort() 메서드를 사용하기로 함.
		// 문제에서 제한시간이 무려 30초나 주는 상황이어서 가장 빠른 정렬 사용 안해도 될거 같아서 선택.
		
		Scanner sc = new Scanner(System.in); 
		// 입력값이 몇개의 줄로 끝나는게 아닌 상황이다.
		// 공백을 기준으로 9~199개의 단어가 이어진 문자열로 주어지기 때문에 
		// br.readline()으로 할 경우 값이 String으로 입력되므로 
		// split 등으로 값을 배열에 담아도 
		// 정렬도 어렵고 이후에 Integer.parseInt()가 필요할 것 같아서,
		// 이 경우에는 Scanner의 사용이 더 합리적이라고 판단해서 Scanner를 사용함.
		int N = sc.nextInt(); 
		sc.nextLine();
		
		int Center = N/2; 
		// 일반 수학적으로 생각해보면 집단의 크기는 "항상" 홀수이기 때문에
		// 중위수의 순번은 집단의크기/2 + 1 이 맞는 수식이다.
		// 그러나 배열의 값을 찾는데 쓰이는 index 값은 0부터 시작하므로 순번과 1만큼 차이가 생긴다.
		// 따라서 1을 더해주지 않아도 도므로 N/2가 일반식이 되었다.
		
		int[] Numbers = new int[N];
		
		for(int i = 0 ; i < N; i++) {
			Numbers[i] = sc.nextInt(); // 공백을 기준으로 값을 배열에 담음.
		}
		sc.nextLine();
		sc.close();
		
		Arrays.sort(Numbers); // 간단히 메서드를 이용해 정렬함.
		System.out.println(Numbers[Center]);		

	}

}
