package algos;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_5431_민석이의과제체크하기 {

	static int N;
	static int[] students;
	
	public static void main(String[] args) {
		/*

1
5 3
2 5 3
		 */
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = sc.nextInt();
		
		for(int t =1 ; t <= T ; t++) {
			sb.append("#"+t+" ");
			N = sc.nextInt();
			students = new int[N+1];
			int P = sc.nextInt();
			
			for(int i = 0 ; i < P ; i ++) {
				int s = sc.nextInt();
				students[s]++;
			}
			
			for(int i  = 1 ; i <= N ; i ++) {
				sb.append(students[i]>0?"":i+" ");
			}
			sb.append("\n");			
		}
		System.out.print(sb.toString());
		
		
		

	}

}
