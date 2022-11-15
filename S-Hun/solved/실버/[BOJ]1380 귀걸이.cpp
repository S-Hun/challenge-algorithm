#include<iostream>
#include<unordered_map>
#include<vector>
#include<string>

using namespace std;

vector<string> name;
unordered_map<string, int> returned;

int main() {
	int input;
	int scene = 1;
	string student;
	cin >> input;
	while (input != 0) {
		name.clear();
		returned.clear();

		cin.ignore();
		for (int i = 0; i < input; i++) {
			getline(cin, student);
			// cout << "[]" << student << '\n';
			name.push_back(student);
		}

		for (int i = 0; i < input * 2 - 1; i++) {
			int n;
			char p;
			cin >> n >> p;
			returned[name[n - 1]] += 1;
		}

		for (auto& n : name) {
			if (returned[n] == 1) {
				cout << scene++ << ' ' << n << '\n';
				break;
			}
		}

		cin >> input;
	}
}