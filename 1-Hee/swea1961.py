
TestCase = int(input()) # 테스트케이스 입력

for idx in range(1, TestCase+1): # 테스트 케이스만큼 반복

    N = int(input()) # 각 케이스별 배열의 크기를 받을 변수
    arr = [list(map(int, input().split())) for _ in range(N)] # 배열 크기가 N*N인 2차배열을 선언과 동시에 값을 입력받아 생성

    trans_arr1 = [[0 for x in range(N)] for _ in range(N)] # 90도 회전 
    trans_arr2 = [[0 for x in range(N)] for _ in range(N)] # 180도 회전
    trans_arr3 = [[0 for x in range(N)] for _ in range(N)] # 270도 회전

    # 90도 회전한다는 것은 배열의크기가 3*3일때,
    # 0,0의 값이 0,2 / 0,1의 값이 1,2 / 0,2의 값이 2,2가 되는 것이다.
    # 이걸 기준으로 일반식을 생각하고 아래와 같이 회전시켰다.
    # 기존의 열의 값은 회전된 배열에서 행의 값이 되고, 열의 값은 새로 계산해야한다.

    # 90도 회전
    for i in range(N): 
        for j in range(N-1, -1, -1):

            k = N-1-i       
            trans_arr1[j][k] = arr[i][j] # 0,2 = 0,0 으로 변환하는 로직.

    # 180도 회전 
    for i in range(N):
        for j in range(N-1, -1, -1):

            k = N-1-i        
            trans_arr2[j][k] = trans_arr1[i][j]

    # 270도 회전
    for i in range(N):
        for j in range(N-1, -1, -1):

            k = N-1-i        
            trans_arr3[j][k] = trans_arr2[i][j]

    print(f"#{idx}") # 테스트케이스 번호 출력

    for i in range(N):
        st = ''
        for j in range(3): # 결과의 총 개수가 배열의 크기 상관 없이 3개임.
            for k in range(N):
                if j == 0:
                    st += str(trans_arr1[i][k])
                elif j == 1:
                    st += str(trans_arr2[i][k])
                else:
                    st += str(trans_arr3[i][k])
            st += ' '    
        print(st) # 741 987 369 이런식으로 1줄에 세 배열의 첫줄을 출력시켜 베틀을 짜듯이 출력함.

                        



        
        