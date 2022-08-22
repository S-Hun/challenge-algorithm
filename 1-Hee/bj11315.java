package com.ssafy.problem.for0822Test;

import java.util.Scanner;

public class BOJ_11315_오목판정 {
	
	/*
	 *	문제풀이 전략
	 *  먼저 사람이 오목을 판정한다면 어떻게 하지 라는 생각을 해봤다.
	 *  그런데, 사람이 오목을 판정하는 방법을 분석해보니 이 방법이 곧 dfs라는 생각이 들었는데,
	 *  왜냐하면 오목판을 딱 보고 오목이 있는 곳을 찾아서(완전탐색) 
	 *  그곳부터 오목이 이어지는 부분(간선이 있는 칸)을 살펴보고 간선의 길이를 기준으로 오목이다 아니다를 판정한다.
	 *  즉 정리하면 2차원 배열을 2중 반복문으로 탐색하면서(완전탐색),
	 *  정점(vertax), 여기서는 오목 'o' 가 있는 부분을 찾자마자 'o'가 있는 즉 간선으로 이어지는 부분을 최대 depth까지 탐색한다. 
	 *  이때의 각 정점에서 leaf 노드까지 깊이 우선 탐색을 함에 따라 깊이를 카운트 계수로 셈할 수 있는데,
	 *  이 카운트 계수 = 오목의 개수 가 되고, 이 오목의 계수로 오목 여부를 판정하면 되겠다고 생각했다.
	 *  그리고, 추가적으로 오목은 한줄이라도 오목이면 오목이니까, 
	 *  본 문제에서는 승자 패자를 겨루는(?)게 아니라 오목판의 오목여부를 판정하라 했으므로, 오목인게 하나라도 발견되면 
	 *  그 즉시 탐색을 종료하고 결과 값(true, YES)를 반환하기로 설계했다.
	 */
	

	static boolean[][] mapsVisited; // 나중에 이 불리언 가지고 육목 판정도 해보자.
	static char[][] maps;
	static int N;
	
	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
         
        int TC = sc.nextInt();
         
        for(int t = 1 ; t <= TC ; t++) {
            sb.append("#"+t+" ");
             
            N = sc.nextInt();
            sc.nextLine();
             
            maps = new char[N][N];
             
            for(int i = 0 ; i < N ; i ++) {
                String x = sc.nextLine();
                for(int j = 0 ; j < N ; j ++) {
                    maps[i][j] = x.charAt(j);
                }
            }
             
            sb.append(findOmok(maps)? "YES" : "NO").append("\n");
             
        }
        System.out.println(sb.toString());
        sc.close();
         
    }
     
    private static boolean findOmok(char[][] maps) {
         
        boolean judge = false;
         
        for(int i = 0 ; i < N; i ++) {
            for(int j = 0 ; j < N ; j ++) {
                if (maps[i][j] =='o') {
                    judge = dfs(i, j);
                }
                if(judge) return judge;
            }
        }
        return false;
         
    }
 
    // 맵을 완탐하는데,
    // 왼쪽 아래, 오른쪽 아래, 아래, 오른    
    static final int[] dx = {1, 1, 1, 0};
    static final int[] dy = {-1, 1, 0, 1};
     
    static boolean dfs(int r, int c) {
        
        
        for(int i = 0 ; i < 4 ; i ++) {
            int cnt = 0;
             
            int dr = r;
            int dc = c;
             
            while(true) {                       
             
                dr += dx[i];
                dc += dy[i];
                 
                if(dr < 0 || dc < 0 || dr >= N || dc >= N) break;
                if (maps[dr][dc]=='o') cnt++;
                else break;
                 
            }
            if(cnt >= 4) return true;
        }
         
        return false;
                 
    }
}
