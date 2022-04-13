import math

a, b = map(int, input().split())
up = math.factorial(a)
down = math.factorial(a-b) * math.factorial(b)
print(a//b)