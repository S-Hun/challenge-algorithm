#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int N, x, y, eat =0, sec = 0;
int ssize = 2;
int map[20][20];
int mindis = 1000000;
int tx =0 ; int ty = 0;
bool visited[20][20];
int re(int x, int y, int dis)
{
    if(x<0||y<0||x>=N||y>=N||visited[y][x]  == 1||(map[y][x] < 9 && map[y][x] > ssize)){
        return 0;
    }else if(0<map[y][x]&&map[y][x]<ssize){
        if(mindis > dis){
            mindis = dis;
            tx = x; ty = y;
        } else if(mindis == dis){
            if(ty > y){
                tx = x; ty = y;
            }else if(ty == y){
                if(tx > x){
                    tx =x; ty = y;
                }
            }
        }
        return 0;
    }
    visited[y][x] = 1;
    re(x+1,y,dis+1); re(x,y+1,dis+1); re(x-1,y,dis+1); re(x,y-1,dis+1);
    visited[y][x] = 0;
    return 0;
}
int main(void)
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> map[i][j];
            if (map[i][j] == 9)
            {
                x = j;
                y = i;
            }
        }
    }
    for(;;){
        re(x,y,0);
        if(mindis == 1000000){
            break;
        }
        map[y][x] = 0;
        map[ty][tx] = 9;
        x = tx; y = ty;
        sec += mindis;
        eat++;
        if(eat == ssize){
            ssize++;
            eat = 0;
        }
        mindis = 1000000;
    }
    cout << sec << endl;
}