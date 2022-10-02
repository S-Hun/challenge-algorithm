package practiceForIM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1983_조교의성적매기기 {

	static class Student implements Comparable<Student>{
		int no;
		int totalPoint;
		
		public Student(int no, int totalPoint) {
			super();
			this.no = no;
			this.totalPoint = totalPoint;
		}

		@Override
		public int compareTo(Student o) {			
			return (this.totalPoint - o.totalPoint)*-1;			
		}		
	}
	
	static Student[] scores;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		String[] grade = new String[] {"A+", "A0", "A-" , "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		
		for(int t= 1 ; t<= T ; t++) {
			sb.append("#"+t+" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int key = Integer.parseInt(st.nextToken())-1;
			
			scores = new Student[N];
			
			for(int i = 0 ; i < N ; i ++) {
				st = new StringTokenizer(br.readLine());
				int middle = Integer.parseInt(st.nextToken())*35;
				int last = Integer.parseInt(st.nextToken())*45;
				int report = Integer.parseInt(st.nextToken())*20;
				
				int total = middle+last+report;
				
				scores[i] = new Student(i, total);
			}
			
			Arrays.sort(scores);
						
			String[] studentGrade = new String[N];
			
			int cut = N/10;
			for(int i = 0 ; i < N ; i ++) {
				studentGrade[scores[i].no] = grade[i/cut];
			}
			
			
			sb.append(studentGrade[key]).append("\n");			
		}
		System.out.print(sb.toString());
		
		
	}
}
