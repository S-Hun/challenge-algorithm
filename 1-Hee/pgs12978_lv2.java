

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
    	
    	// ��� ���� ����Ʈ�� �ʱ�ȭ
    	ArrayList<ArrayList<Nodes>> graph = new ArrayList<ArrayList<Nodes>>();
    	for(int i = 0 ; i < NodeNumber+1 ; i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	// �׷����� ���� �ֱ�
    	for(int i = 0 ; i< NodeCase;  i++) {
    		int head = road[i][0];
    		int tail = road[i][1];
    		int cost = road[i][2];
    		    		
    		graph.get(head).add(new Nodes(tail, cost));
    		graph.get(tail).add(new Nodes(head, cost));
    	}
    	
    	// �湮 ���θ� Ȯ���� �Ҹ��� �迭, start���� end���� �ּ� �Ÿ��� ������ �迭 ����
    	
    	boolean[] visited = new boolean[NodeNumber+1];
    	int[] dist = new int[NodeNumber+1];
    	
    	// �ּҰŸ� ������ ���� �迭�� �ʱ�ȭ ��.
    	for(int i = 0 ; i< NodeNumber+1; i++) {
    		// ������� �̿��� ������ �������� �ּҺ���� �ִ�� ��������.
    		dist[i]= Integer.MAX_VALUE;
    	}
    	
    	dist[start] = 0 ;
    	
    	//////////////////////////////////////////////////////
    	
    	for (int i = 0; i < NodeNumber; i++) {
			// 4 - 1. ���� �Ÿ� ��� �� �ּ��� ������ �����Ѵ�.
			// �ش� ��尡 ������ �ִ� ���� ���.
			int nodeValue = Integer.MAX_VALUE;
			// �ش� ����� �ε���(��ȣ).
			int nodeIdx = 0;
			// �ε��� 0�� �������� �ʱ� ������ 0���� �ݺ��� �����Ѵ�.
			for (int j = 1; j < NodeNumber+1; j++) {
				// �ش� ��带 �湮���� �ʾҰ�, ���� ��� �Ÿ���� �� �ּڰ��� ã�´�.
				if (!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}
			// ���� ���õ� ��带 �湮ó�� �Ѵ�.
			visited[nodeIdx] = true;

			// 4 - 2. �ش� ������ �������� ���� ����� �ּ� �Ÿ� ���� �����Ѵ�.
			for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
				// ���� ��带 �����Ѵ�.
				Nodes adjNode = graph.get(nodeIdx).get(j);

				// ���� ��尡 ���� ������ �ּ� ����
				// ���� ���õ� ����� �� + ���� ��忡�� ���� ���� ���� ���� ���Ͽ� �� ���� ������ �����Ѵ�.
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