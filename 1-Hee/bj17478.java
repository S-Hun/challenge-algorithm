package bakjoon2;

import java.util.Scanner;

public class bj17478_al_step9_3 {
	
	static String recTap = "";
	
	public static void Recurrsive(int n) {
		
		// 출력을 보고 재귀의 범위를 판단한 후 재귀를 구현하는 문제.
		
		String tap = recTap;
		
		if(n==0) { // 테스트 케이스로 주어진 것을 보았을 때는, 재귀가 총 2종류라는 것을 알수 있음. 그래서 여기에 적힌 문장은 최초에 1번만 출력되도록 함. 
			System.out.println(tap+"\"재귀함수가 뭔가요?\"");
			System.out.println(tap+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(tap+"라고 답변하였지.");
			return;
		}
		
		System.out.println(tap+"\"재귀함수가 뭔가요?\""); // n부터 0이 될때까지 계속 반복될 문장들, 문제에서 추가한 "____" (언더바) 표시는 변수 tap으로 추가함.
		System.out.println(tap + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		System.out.println(tap + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		System.out.println(tap + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		
		
		recTap+= "____"; // static으로 재귀함수와 상관없이 별도로 변수를 선언하고, 재귀가 호출될때마다 tap이 쌓이고, n회 쌓은것부타 탭이 줄어드는 양상을 보여줌.
		Recurrsive(n-1);
		System.out.println(tap+"라고 답변하였지.");
		
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		Recurrsive(n);
		sc.close();

	}
}
