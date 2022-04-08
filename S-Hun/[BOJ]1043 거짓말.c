#include<iostream>
#include<vector>

using namespace std;
int N, M, T;
vector<int> truth;
vector<vector<int>> party_members;

void init() {
	cin >> N >> M >> T;
	int temp;
	for (int i = 0; i < T; i++) {
		cin >> temp;
		truth.push_back(temp-1);
	}
	int member_number;
	for (int i = 0; i < M; i++) {
		cin >> member_number;
		party_members.push_back(vector<int>());
		for (int j = 0; j < member_number; j++) {
			cin >> temp;
			party_members[i].push_back(temp-1);
		}
	}
}

int party_check() {
	vector<bool> parties(M, false);
	vector<bool> members(N, false);
	for (auto& t : truth) members[t] = true;
	bool dif = true;
	while (dif) {
		dif = false;
		for (int i = 0; i < M; i++) {
			if (parties[i]) continue;
			else {
				for (auto& m : party_members[i]) {
					if (members[m]) {
						parties[i] = true;
						dif = true;
						for (auto& k : party_members[i]) members[k] = true;
					}
				}
			}
		}
	}
	int cnt = 0;
	for (auto p : parties)
		if (!p) cnt++;
	return cnt;
}

int main() {
	init();
	cout << party_check();
}