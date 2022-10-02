# 문제접근 법
# 해당 문제에서는 무조건 2차원 배열이 주어진다, 2차원 배열의 모양이 정사각형인 배열이다.
# 문제에서 원하는 것은 길이가 K인 글자가 들어갈 수 있는 곳의 갯수를 원한다.
# 만약 빈칸의 길이가 5라면 글자의 길이 K=3 일때는 해당 칸에 넣을 수 없다.
# 이러한 제약조건을 모두 만족시키기 위해 아래의 로직을 구성했다.


TestCase = int(input()) # 전체 테스트 케이스 입력

for idx in range(TestCase): # 테스트케이스만큼 로직 반복

    N, K = map(int, input().split()) # 배열의 크기, 원하는 글자크기 받고
    arr = [list(map(int, input().split())) for _ in range(N)] 
    # 배열 크기로 배열을 만드는데, 배열에 들어갈 값은 0또는 1로 주어지므로
    # 이 값을 받는 즉시 배열에 담아 2차원 배열을 생성.
        
    # 행탐색
    rows = []

    for r in range(N): 
        count = 0 # 빈칸의 개수를 기록할 변수
        record = [] # 행별 빈칸의 개수를 기록할 배열
        for c in range(N): # 행 전체 탐색
            if arr[r][c]: # 파이썬의 Falsy, 빈칸이 아닌 곳은 0으로 표시되므로 빈칸인 곳만 패스!
                count += 1 # count를 증가시켜 빈칸을 셈함.
            else:
                if count: # 빈칸이 연속되지 않을 경우 카운트를 끊어야함.
                    record.append(count) # 누적합을 저장하고.           
                count = 0 # 0으로 초기화해서 다시 빈칸을 셈함.
    
        if count: # 반복문을 다 종료하고 count의 값이 남아있으면(마지막에 연속된 빈칸이 생기면)
            record.append(count)  # 마지막으로 빈칸의 수를 저장하고          
        rows.append(record) # 행별 빈칸의 크기를 각각 입력.

    rows_cnt = 0 # k를 만족하는 빈칸 탐색을 위한 카운트 변수

    for eachs in rows: # 전체 빈칸 배열을 탐색해서
        for j in eachs:
            if K == j: # 빈칸에 값이 입력값에서 원하는 경우가 있다면
                rows_cnt += 1 # 셈한다.


    
    # 열탐색
    columns = []

    for r in range(N):
        count = 0
        record = []
        for c in range(N):
            if arr[c][r]: # 이중 반복문에서 행과 열을 바꾸면 열탐색이 됨, 나머지는 위의 원리와 동일합니다.
                count += 1
            else:
                if count:
                    record.append(count)            
                count = 0
    
        if count:
            record.append(count)            
        columns.append(record)

    columns_cnt = 0

    for eachs in rows:
        for j in eachs:
            if K == j:
                columns_cnt += 1 
        


    print(f'#{idx+1} {row_cnt+columns_cnt}') # 행과 열을 모두 탐색하여 K를 만족하는 경우의 수의 합을 리턴.


        

