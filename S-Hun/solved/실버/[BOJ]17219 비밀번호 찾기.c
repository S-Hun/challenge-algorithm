#include<iostream>
#include<unordered_map>
#include<string>

using namespace std;
int N, M;
unordered_map<string, string> acc;

void init() {
	cin >> N >> M;
	string url, pwd;
	for (int i = 0; i < N; i++) {
		cin >> url >> pwd;
		acc[url] = pwd;
	}
}

void solution() {
	string url;
	for (int i = 0; i < M; i++) {
		cin >> url;
		cout << acc[url] << '\n';
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	init();
	solution();
}
