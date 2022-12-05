#include<iostream>
#include<string>
#include<vector>

using namespace std;

int main() {
	vector<string> names;
	vector<vector<bool>> messages;
	int counts;

	int num;
	cin >> num;
	for (int t = 1; num != 0; t++) {
		names.resize(num);
		messages.assign(num, vector<bool>());
		counts = 0;

		char ans;
		for (int i = 0; i < num; i++) {
			cin >> names[i];
			for (int j = 0; j < num - 1; j++) {
				cin >> ans;
				if (ans == 'P') messages[i].push_back(false);
				else { messages[i].push_back(true); counts++; }
			}
		}

		cout << "Group " << t << '\n';
		if (counts == 0) {
			cout << "Nobody was nasty\n\n";
		}
		else {
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num - 1; j++) {
					if (messages[i][j]) {
						cout << names[(i + num - j - 1) % num] << " was nasty about " << names[i] << '\n';
					}
				}
			}
			cout << '\n';
		}

		cin >> num;
	}
}