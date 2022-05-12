package bakjoon2;

import java.util.Scanner;

public class bj17478_al_step9_3 {
	
	static String recTap = "";
	
	public static void Recurrsive(int n) {
		
		// ����� ���� ����� ������ �Ǵ��� �� ��͸� �����ϴ� ����.
		
		String tap = recTap;
		
		if(n==0) { // �׽�Ʈ ���̽��� �־��� ���� ������ ����, ��Ͱ� �� 2������� ���� �˼� ����. �׷��� ���⿡ ���� ������ ���ʿ� 1���� ��µǵ��� ��. 
			System.out.println(tap+"\"����Լ��� ������?\"");
			System.out.println(tap+"\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			System.out.println(tap+"��� �亯�Ͽ���.");
			return;
		}
		
		System.out.println(tap+"\"����Լ��� ������?\""); // n���� 0�� �ɶ����� ��� �ݺ��� �����, �������� �߰��� "____" (�����) ǥ�ô� ���� tap���� �߰���.
		System.out.println(tap + "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		System.out.println(tap + "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		System.out.println(tap + "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
		
		
		recTap+= "____"; // static���� ����Լ��� ������� ������ ������ �����ϰ�, ��Ͱ� ȣ��ɶ����� tap�� ���̰�, nȸ �����ͺ�Ÿ ���� �پ��� ����� ������.
		Recurrsive(n-1);
		System.out.println(tap+"��� �亯�Ͽ���.");
		
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		Recurrsive(n);
		sc.close();

	}
}
