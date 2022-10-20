package algos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_2382_점심식사시간  {
	
	/* 문제풀이 전략
	 *  
	 *  입구는 2개로 고정이고, 사람들이 어떤 계단을 사용하느냐에 따라서 전체 소요 시간이 달라지는 문제이다.
	 *  문제에서 출력을 요구하는 값은 전체 경우의 수 중에서 가장 작은, 즉 최소 이동시간을 요구한다.
	 *  
	 *  본 문제에서는 입력값으로 주어지는 2차원 배열에서 사람들의 좌표만 기억하고, 
	 *  거리를 계산하는 공식을 제공 했으므로 이 식을 이용해서 계산한 값 만을 기록해두기로 했다.
	 * 
	 *  이번에 필요한 메서드는 총 2가지로 생각되었다.
	 *  1. 사람들의 이동 경로의 경우의 수를 모두 구해주는 메서드	-> 	부분집합이 가장 적합하다 생각하여 부분집합을 선택.
	 *  2. 사람들의 이동 경로 정보를 기준으로  각 경우의 수마다 총 이동 시간을 계산해주는 메서드 (가장 마지막 사람의 이동 종료 시간을 게산해야함)
	 *  
	 *  구현에서 가장 까다로웠던 포인트는 2번 메서드에서 두 가지 조건이 추가로 들어갔다는 점인데,
	 *  1) 입구 도착과 동시에 이동을 시작하지 않으며 바로 도착해도 최소 계단의 길이 + 1 만큼의 이동 시간이 소요된다.
	 *  2) 계단에서 이동할 수 있는 최대 인원은 3명으로 고정이며, 계단에 진입한 사람이 완전히 계단으로부터 나와야지 그다음 사람이 진입할 수 있어서
	 *  계단에 사람이 몰리면 쓰레드처럼 이동을 제어해주고, 대기하는 사람들의 시간도 이동시간을 갱신해줘야하는 것.
	 *  
	 *  이 두가지가 까다로웠던 포인트였던 것 같다.
	 *  
	 */
	
	
	
	// 입구 정보를 저장할 class
	static class Entrance {
		int x, y, time;
		
		public Entrance(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;	// 계단의 길이 = 계단 이동시간 이므로 변수 명울 time으로 해둠.
		}
	}
	
	// 사람의 정보를 기록할 class
	// 각 사람의 위치, 선택한 입구, 입구 도착시간, 계단 통과 시간을 기록함.
	static class People {
		int x, y;		// 사람의 좌표
		int entranceNo;	// 입구 번호 ( 0 or 1 )
		int arriveTime;	// 입구 도착 시간,		문제에서 주어진 식의 계산으로부터 구함.
		int stairTime;	// 게단 도착 시간
		
		People() {}
		People(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		// 입구에 도착할 때 까지 시간을 계산하는 메서드를 멤버 메서드로 귀속시켜줘서, 나중에 사람마다 시간을 계산할 수 있게 해줌. 
		private void calcArriveTime() {
			this.arriveTime = 
					Math.abs(this.x-entrances[this.entranceNo].x)
					+Math.abs(this.y-entrances[this.entranceNo].y);
		}
		
	}
	static Queue<People>[] qs; 				// 2번 메서드 구현은 BFS가 적합한데 , 이에 사용할 Queue를 담은 배열, 입구 1 과 2의 Queue를 담음. 
	static ArrayList<People> peoples;		// 사람들의 정보를 담을 리스트
	static boolean[] isVisited;				// 2번 메서드에서 사용할 방문 처리용 boolean 배열
	static Entrance[] entrances;			// 입구 정보를 저장할 배열
	static int N, ans;						// 입력 배열의 크기 / 최소 방문 시간
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("data/swea2383.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1 ; t<=T ; t++) {
			sb.append("#"+t+" ");
			
			N = Integer.parseInt(br.readLine());
			
			// 멤버 변수로 설정한 static 변수들을 테스트 케이스마다 독립적으로 사용하기 위해 초기화 해준다.
			peoples = new ArrayList<>();
			qs = new LinkedList[2];
			qs[0] = new LinkedList<People>();
			qs[1] = new LinkedList<People>();
			entrances = new Entrance[2];
			ans = Integer.MAX_VALUE;
			
			for(int i = 1 ; i <= N ; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1 ; j <= N ; j ++) {
					int value = Integer.parseInt(st.nextToken());
					
					if(value==0) continue;	// 0 = 빈 값이자 사람이 없는 것이므로 제외.
					
					else if(value==1) {		// 1 = 사람 으로 약속되었으므로, 사람의 좌표를 구하고 사람 리스트에 추가.
						People p = new People(i, j);
						peoples.add(p);												
					
					}else {
						// 입구에 정보를 init 해주는 분기 구간인데, 입구도 2개로 고정이므로 2차원 배열 탐색하면서 입구 정보도 세팅.
						if(entrances[0] == null) 
							entrances[0] 
									= new Entrance(i, j, value);						
						else if(entrances[1] == null) 
							entrances[1] 
									= new Entrance(i, j, value);					
					}
				}
			}	
			
			subset(0);	// 이동 경로 경우의 수에 대한 부분 집합 메서드
			sb.append(ans).append("\n");
			
		}
		
		System.out.print(sb.toString());
		
		
	}


	private static void subset(int idx) {
		
		if(idx==peoples.size()) {
			isVisited = new boolean[peoples.size()];	// 각 경우의 수마다 사용할 BFS용 방문처리 배열
			
			 int cur = BFS();		// 리턴 값으로 해당 경우의 총 이동 시간을 리턴해줌.
			
			ans = ans > cur ? cur : ans;	// 최소 비교
			return;			
		}
		
		peoples.get(idx).entranceNo = 0;
		peoples.get(idx).calcArriveTime();		
		subset(idx+1);
		
		peoples.get(idx).entranceNo = 1;
		peoples.get(idx).calcArriveTime();		
		subset(idx+1);

		
	}


	private static int BFS() {
		
		int cnt = 0;
		int time = 1;
		
		while(true) {
			
			// 계단을 탈출시키는 메서드
			for(Queue<People> q : qs) {
				int size = q.size();
				
				for(int i = 0 ; i < size ; i++) {
					People p = q.poll();
					Entrance e = entrances[p.entranceNo];
					if(p.stairTime + e.time <= time) continue; // 계단 도착 시간 + 계단 이동 시간이 현재 시간보다 작다 = 이미 이동했고도 남은 시간이다.
					// 계단 도착 시간은 큐의 사정(인원)에 따라서 증가처리 되어 들어오므로 위의 대소 비교식이 성립하는 것.
					q.offer(p);	// 위 조건 만족 못했다 = 아직 이동중이다 = 큐에 다시 값을 넣는다.
					
				}
			}
			
			// 모든 사람들이 계단에 진입했고, 모든 큐가 비어있는 상태면 메서드 종료하고 이 때 소요된  시간 time 을 리턴.
			if(cnt == peoples.size() && qs[0].isEmpty() && qs[1].isEmpty())
				return time;
			
			
			for(int i = 0 ; i < peoples.size() ; i++) {
				if(isVisited[i]) continue;	// 방문했을 경우 제외

				People p = peoples.get(i);
				Queue<People> q = qs[p.entranceNo];
				
				// 계단 입구까지 도착시간이 현재시간(time) 보다 크거나 같다면 입구에 도착한 것이다.
				// 또한, 큐의 사이즈가 3보다 작다 = 빈공간이 있다 이므로,
				if(p.arriveTime+1 <= time && q.size() < 3) {
					p.stairTime = time;	// 계단 도착 시간을 세팅해주고
					isVisited[i] = true;	// 방문처리 한다음
					q.offer(p);				// 큐에 넣고
					cnt++;					// cnt = 큐에 들어간 사람 수를 증가.
				}
				
			}
			
			time++;	// 시간을 계속 증가시켜준다.
			
		}
		
		
	}
	
}