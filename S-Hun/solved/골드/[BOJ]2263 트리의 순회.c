#include<iostream>
#include<vector>
#include<utility>
#include<stack>

using namespace std;
int n;
vector<int> inorder;
vector<int> postorder;

void init() {
	cin >> n;
	int temp;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		inorder.push_back(temp);
	}
	for (int i = 0; i < n; i++) {
		cin >> temp;
		postorder.push_back(temp);
	}
}

void solution(int s1, int s2, int l) {
	if (l < 1) return;
	/*
	for (int i = s1; i < s1 + l; i++) {
		cout << "v" << inorder[i] << " ";
	}
	cout << "\n";
	*/
	int div = find(inorder.begin() + s1, inorder.begin() + s1 + l, postorder[s2+l-1]) - inorder.begin() - s1;
	//cout << "div" << div << " ";
	cout << *(inorder.begin() + s1 + div) << " ";
	solution(s1, s2, div);
	solution(s1 + div + 1, s2 + div, l - div - 1);
	//cout << "end" << "\n";
	// inorder : [1] div [2]
	// postorder : [1] [2] div
 }

int main() {
	init();
	solution(0, 0, n);
}
