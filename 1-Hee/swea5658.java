package algoDay01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_5658_����SW�����׽�Ʈ_��������_��й�ȣ {

	public static void main(String[] args) throws IOException {
				
		/* Ǯ�� ����
		 * 
		 * ��ũ�� ����Ʈ�� ���ؼ� �ڹ��谡 ���ư��� ������ ������.
		 * �ڹ����� ����� �������̹Ƿ� �Ѹ��� ��й�ȣ�� ���̴� ��ü ��й�ȣ ���� N�� 4�� ������ ���� ��.
		 * 
		 * �ڹ��踦 ȸ�������� �� ��й�ȣ�� �ϳ��� �ٸ� ����� ����
		 * �ʱ� ��й�ȣ�� �� ���� ��й�ȣ���� �̿��� ������ �̵��� �� ������.
		 * 
		 * ������ �ڹ��� �� ��й�ȣ ���̰� 12��� N/4
		 * �� ũ�Ⱑ �� �ڹ��谡 ȸ���� �� �ִ� ȸ�� �� "cycle"�̶�� �����߰� ������ ����� ���� �� ȸ�� ��Ŵ
		 *  
		 * ȸ���ϸ� ������ ��� ��й�ȣ ����� ���� �� �� ������ �迭�� ����
		 * 
		 * ���ڿ��� ��й�ȣ�� �׳� ���ĸ� �ص� 16���� �������� ������������ ������ ��
		 * �׷��� Integer.parseInt() �޼��带 �̿��� �� ��ȯ���ִ� �Ŷ�
		 * k�� ���ϴ� �Ϳ� �����Ͽ� ���� �ۼ�.
		 */
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			
			int size = Integer.parseInt(st.nextToken());
			int cycle = size/4;
			int k = Integer.parseInt(st.nextToken());
			
			// �� ��й�ȣ�� ����� ��ũ�� ����Ʈ
			LinkedList<Character> passWord = new LinkedList<>();
			String rawPass = br.readLine(); // �Է°��� ���� ��
			
			for(int i = 0 ; i < rawPass.length(); i ++) {
				passWord.add(rawPass.charAt(i)); // char ������ �迭�� ����
			}
						
			ArrayList<String> allpass = new ArrayList<>(); // ��� ��쿡�� ���� ��й�ȣ���� ���� �����ϱ� ���� ArrayList
			for(int i = 0 ; i < cycle ; i ++) {
				
				String[] temp = checkPass(passWord, cycle);
				concatPass(allpass, temp);				
				passWord.addLast(passWord.removeFirst());
				
			}
			
			
			Collections.sort(allpass);	// ������������ ����		

			String temp = "";			

			int rank = 1; // 1���� ���ϰ�
			for(int i = allpass.size()-1; i >= 0 ; i --) {
				
				if(temp.equals(allpass.get(i))) continue; // ������ rank ++ �ϸ� �ȵǴϱ� �ݺ����� continue;
				temp = allpass.get(i);			
				if(rank == k) break;
				rank++;
			}
			sb.append(Integer.parseInt(temp,16)).append("\n"); // ����� ����
						
		}
		
		System.out.print(sb.toString());
		
		
	}
		
	// 1ȸ�� ������ �� ���� ��й�ȣ���� �������ִ� �޼���
	private static String[] checkPass (LinkedList input, int cycle){
		
		String[] passArr = new String[4];
		int idx = 0;
		for(int i = 0 ; i < input.size(); i += cycle) {
			String tempPass = "";
			for(int j = 0 ; j < cycle ; j ++ ) {
				tempPass+=input.get(i+j);
			}
			passArr[idx++] = tempPass;
		}
		return passArr;
	}
	
	// 1ȸ������ �� �� ���� ��й�ȣ���� �ϳ��� �迭�� �����ִ� �޼���
	private static void concatPass(ArrayList<String> allpass, String[] input) {
		
		for(int i = 0 ; i < input.length; i ++) {
			allpass.add(input[i]);
		}
		
	}

}
