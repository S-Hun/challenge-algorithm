#include<iostream>
#include<cmath>

using namespace std;
struct point {
	double x, y;

	point() : x(0), y(0) {}
	point(double x, double y) : x(x), y(y) {}

	void operator=(const point& a) {
		this->x = a.x;
		this->y = a.y;
	}
	friend istream& operator>>(istream& is, point& a);
};

istream& operator>>(istream& is, point& a) {
	is >> a.x >> a.y;
	return is;
}

int n;
double sum = 0;
point p0, p1, p2;

void input() {
	cin >> n;
	cin >> p0 >> p1;
}

double outer_area(point p0, point p1, point p2) {
	point v1{ p1.x - p0.x, p1.y - p0.y }, v2{ p2.x - p0.x, p2.y - p0.y };
	return v1.x * v2.y - v1.y * v2.x;
}

double area(point p0, point p1) {
	return (p0.x + p1.x) * (p0.y - p1.y);
}

void solution() {
	for (int i = 2; i < n; i++) {
		cin >> p2;
		sum += outer_area(p0, p1, p2);
		p1 = p2;
	}
	cout.setf(cout.fixed);
	cout.precision(1);
	cout << abs(sum) / 2;
}

int main() {
	input();
	solution();
}