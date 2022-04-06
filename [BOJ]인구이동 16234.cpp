#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


vector<pair<int, int>> house,chi;
int N,L,R,num = 0;
int result = 0;
int map[50][50];
bool visited[50][50];
int re(int x, int y,int xx, int yy){
    if(x==xx&&y==yy){
        visited[y][x] = 1; num++;
        return re(x,y,x+1,y)+re(x,y,x,y-1)+re(x,y,x-1,y)+re(x,y,x,y+1)+map[y][x];
    }
    if(xx == N || yy == N || xx== -1|| yy == =1||visited[yy][xx] == 1||abs(map[y][x]-map[yy][xx])<L||abs(map[y][x]-map[yy][xx])>R){
        return 0;
    }
    x = xx; yy = yy; num++; visited[y][x] = 1;
    return re(x,y,x+1,y)+re(x,y,x,y-1)+re(x,y,x-1,y)+re(x,y,x,y+1)+map[y][x];
}

int main(void)
{
    cin >> N >> L >> R;
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            cin >> map[i][j];
        }
    }
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            if(visited[i][j] == 0){
                re();
            }
        }
    }
}