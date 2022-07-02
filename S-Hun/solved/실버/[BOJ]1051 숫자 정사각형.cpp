#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

int main(int argc, char *argv[])
{
	int n, m;
	int map[51][51];
	string line;
	cin >> n >> m;
	for(int i=0; i<n; i++) {
		cin >> line;
		for(int j=0; j<m; j++) {
			map[i][j]=line[j]-'0';
		}
	}
	int min_size = min(n, m);
	for(int s=min_size-1; s>0; s--){
		for(int i=0; i<n-s; i++){
			for(int j=0; j<m-s; j++){
				if(map[i][j] == map[i][j+s]
				&& map[i][j] == map[i+s][j]
				&& map[i][j] == map[i+s][j+s]) {
					cout << (s+1)*(s+1);
					return 0;
				}
			}
		}
	}
	cout << 1;
}
