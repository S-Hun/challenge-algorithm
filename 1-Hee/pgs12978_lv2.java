

import java.util.ArrayList;




// 5	[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]	3	4

public class pgs12978_lv2 {
	public static void main(String[] args) {
		
		
		int N = 5;
		int K = 3;
		int[][] road = { {1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}};
		
		Solution45 fezt = new Solution45();
		System.out.println(fezt.solution(N, road, K));
				
		
	}
}


class Nodes {
	int idx;
	int cost;
	
	Nodes(int idx, int cost){
		this.idx = idx;
		this.cost = cost;
	}
}


class Solution45 {
    public int solution(int N, int[][] road, int K) {
    	
    	
    	int NodeNumber = N;
    	int NodeCase = road.length;
    	int start = 1;
    	int count = 0;
    	
    	// 노드 인접 리스트의 초기화
    	ArrayList<ArrayList<Nodes>> graph = new ArrayList<ArrayList<Nodes>>();
    	for(int i = 0 ; i < NodeNumber+1 ; i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	// 그래프의 값을 넣기
    	for(int i = 0 ; i< NodeCase;  i++) {
    		int head = road[i][0];
    		int tail = road[i][1];
    		int cost = road[i][2];
    		    		
    		graph.get(head).add(new Nodes(tail, cost));
    		graph.get(tail).add(new Nodes(head, cost));
    	}
    	
    	// 방문 여부를 확인할 불리언 배열, start부터 end까지 최소 거리를 저장할 배열 생성
    	
    	boolean[] visited = new boolean[NodeNumber+1];
    	int[] dist = new int[NodeNumber+1];
    	
    	// 최소거리 정보를 담을 배열을 초기화 함.
    	for(int i = 0 ; i< NodeNumber+1; i++) {
    		// 출발지점 이외의 나머지 지점까지 최소비용은 최대로 지정해줌.
    		dist[i]= Integer.MAX_VALUE;
    	}
    	
    	dist[start] = 0 ;
    	
    	//////////////////////////////////////////////////////
    	
    	for (int i = 0; i < NodeNumber; i++) {
			// 4 - 1. 현재 거리 비용 중 최소인 지점을 선택한다.
			// 해당 노드가 가지고 있는 현재 비용.
			int nodeValue = Integer.MAX_VALUE;
			// 해당 노드의 인덱스(번호).
			int nodeIdx = 0;
			// 인덱스 0은 생각하지 않기 때문에 0부터 반복을 진행한다.
			for (int j = 1; j < NodeNumber+1; j++) {
				// 해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값을 찾는다.
				if (!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}
			// 최종 선택된 노드를 방문처리 한다.
			visited[nodeIdx] = true;

			// 4 - 2. 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신한다.
			for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
				// 인접 노드를 선택한다.
				Nodes adjNode = graph.get(nodeIdx).get(j);

				// 인접 노드가 현재 가지는 최소 비용과
				// 현재 선택된 노드의 값 + 현재 노드에서 인접 노드로 가는 값을 비교하여 더 작은 값으로 갱신한다.
				if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost) {
					dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
				}
			}
		}

    	
    	for(int i = 1 ; i< NodeNumber+1; i++) {
    		if(dist[i]<=K) {
    			count++;
    		}
    	}
    	
        int answer = count;
        return answer;
    }
}