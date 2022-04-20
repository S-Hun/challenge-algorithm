package bakjoon2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj10250_al_step7_5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int Case = sc.nextInt();
		sc.nextLine();
		
		int[] answer = new int[Case];
		String ReservedRoom = "";
		
		for(int i = 0 ; i < Case; i ++) {
			String input = sc.nextLine();
			StringTokenizer st = new StringTokenizer(input);
			int Height = Integer.parseInt(st.nextToken());
			int Width = Integer.parseInt(st.nextToken());
			int Numbers = Integer.parseInt(st.nextToken());
			
			int floor = 0;
			int Rooms = 0;
			
			if(Numbers%Height==0) {
				floor = Height;
				Rooms = Numbers/Height;
				
			} else {
				floor = Numbers%Height;
				Rooms = Numbers/Height+1;
			}
			
			if(Rooms<10) {
				ReservedRoom += String.valueOf(floor);
				ReservedRoom += String.valueOf(0);
				ReservedRoom += String.valueOf(Rooms);

			} else {
				ReservedRoom += String.valueOf(floor);
				ReservedRoom += String.valueOf(Rooms);
			}
			
			answer[i] = Integer.valueOf(ReservedRoom);
			ReservedRoom ="";
		}
		
		for(int i = 0 ; i < Case; i ++) {
			System.out.println(answer[i]);
		}

	}

}
