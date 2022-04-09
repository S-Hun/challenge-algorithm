#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


vector<pair<int, int>> house,chi;
int N,M;
int result = 1000000000;
int map[50][50];
int sel[13];
void re(int n, int s){
    if(s == M){
        int sum =0;
        for(int i =0;i<house.size();i++){
            int min = 100000000;
            for(int j = 0 ; j< chi.size();j++){
                if(sel[j] == 1){
                    min = min<abs(house[i].first-chi[j].first)+abs(house[i].second-chi[j].second)?min:abs(house[i].first-chi[j].first)+abs(house[i].second-chi[j].second);
                }
            }
            sum += min;
        }
        result = result<sum ? result: sum;
        return;
    }
    if(n == chi.size()){
        return;
    }
    sel[n] = 1;
    re(n+1,s+1);
    sel[n] = 0;
    re(n+1,s);
    return;
}

int main(void)
{
    cin >> N >> M;
    for(int i = 0 ; i < N;i++)
    {
        for(int j =0;j<N;j++)
        {
            cin >> map[i][j];
            if(map[i][j] == 1)
            {
                house.push_back({i, j});
            }
            else if(map[i][j] == 2)
            {
                chi.push_back({i,j});
            }
        }
    }
    re(0,0);
    cout<<result;
}