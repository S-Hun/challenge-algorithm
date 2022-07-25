
T = int(input())

answer = []

for t in range(T): # 전체 테스트 케이스
    
    lengths = list(map(int, input().split())) # 그다음에 들어올 배열의 크기 값
    
    times = int(abs(lengths[0]-lengths[1])+1) # 전체 반복할 횟수를 셈하는 일반식 (대소관계 상관 없음)

    s1 = list(map(int, input().split())) # 일단 배열 복사
    s2 = list(map(int, input().split()))

    # 배열의 크기에 따라 작으면 arrA, 크면 arrB로 하기로 함.
    if len(s1) > len(s2):
        arrA = s2
        arrB = s1
    else:
        arrA = s1
        arrB = s2
        
    temp = 0
    for i in range(times):
        multy_sum = 0
        for j in range(len(arrA)):
            multy_sum += arrA[j] * arrB[i+j]

        if temp < multy_sum:
            temp = multy_sum

    answer.append(f'#{t+1} {temp}')

for i in answer:
    print(i)