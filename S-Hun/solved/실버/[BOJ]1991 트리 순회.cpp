#include<iostream>
#include<vector>

using namespace std;
int n;
struct Node {
	int left = -1;
	int right = -1;
};
vector<Node> tree;

void init() {
	cin >> n;
	tree.resize(n);
	char v, l, r;
	for (int i = 0; i < n; i++) {
		cin >> v >> l >> r;
		if (l != '.') tree[v - 'A'].left = l - 'A';
		if (r != '.') tree[v - 'A'].right = r - 'A';
	}
}

void pre(int node = 0) {
	cout << char('A' + node);
	if (tree[node].left != -1) pre(tree[node].left);
	if (tree[node].right != -1) pre(tree[node].right);
}

void in(int node = 0) {
	if (tree[node].left != -1) in(tree[node].left);
	cout << char('A' + node);
	if (tree[node].right != -1) in(tree[node].right);
}

void post(int node = 0) {
	if (tree[node].left != -1) post(tree[node].left);
	if (tree[node].right != -1) post(tree[node].right);
	cout << char('A' + node);
}

void solve() {
	pre();
	cout << '\n';
	in();
	cout << '\n';
	post();
	cout << '\n';
}

int main() {
	init();
	solve();
}