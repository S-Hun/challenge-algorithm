#include<iostream>
#include<string>
#include<vector>

using namespace std;
string str1;
string str2;

void init() {
	cin >> str1 >> str2;
}

void solution() {
	vector<char> ans;
	int sz1 = str1.size(), sz2 = str2.size();
	for (int i = 0; i < sz1; i++) {
		ans.push_back(str1[i]);
		if (ans.size() >= sz2) {
			int pos = 0;
			while (str2.rbegin() + pos != str2.rend() && *(ans.rbegin() + pos) == *(str2.rbegin() + pos)) pos++;
			if (pos == sz2) {
				for (int j = 0; j < sz2; j++) ans.pop_back();
			}
		}
	}
	if (ans.empty()) cout << "FRULA";
	else for (auto& c : ans) cout << c;
}

int main() {
	init();
	solution();
}