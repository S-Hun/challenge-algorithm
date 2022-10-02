'''

10
5 2
1 3 3 6 7
8 13 9 12 8
4 16 11 12 6
2 4 1 23 2
9 13 4 7 3
6 3
29 21 26 9 5 8
21 19 8 0 21 19
9 24 2 11 4 24
19 29 1 0 21 19
10 29 6 18 4 3
29 11 15 3 3 29

'''


Total = int(input()) # 총 테스트 케이스를 받을 변수 Total 선언

for idx in range(1, Total+1): # 반복문의 idx는 사실 아래에서 안써도 되는데, 마지막 출력에 index 번호로 쓰려고 이렇게 구성.

    N, M = map(int, input().split()) # 값이 2개가 들어올 것이 명백하므로 서로 다른 변수에 분할해서 담음, Pythonic!

    maps = [list(map(int, input().split())) for _ in range(N)] # 파리의 개수를 담은 배열이 문자열로 들어오면 2차배열로 변환함.

    n = M - 1 #배열의 이동 범위를 제한하기 위해 연산에 사용할 변수 n 선언

    max = 0 # 전체 최대 파리 킬 수 담는 max 변수 선언.
    for r in range(N-n): # 배열에 5줄이면 1개씩 보는게 아니라 여러개씩 볼 것이므로 전체배열의 수에서 n만큼 움직이게 제한.
        for c in range(N-n):
            area = 0

            # M * M 사이즈의 배열값을 모두 더하는 2중 반복문
            for dr in range(M): 
                for dc in range(M):
                    area += maps[r+dr][c+dc]
        
            if max < area: # 2중 반목문 후에 최대값과 비교
                max = area

    print(f'#{idx} {max}') # 각 케이스별로 양식에 맞추어 출력

                
        

