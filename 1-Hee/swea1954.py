TestCase = int(input())

for T in range(TestCase):
    size = int(input())
    place = [[0 for _ in range(size)] for _ in range(size)]
    result = ""

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    dr = [0, 1, 2, 3]

    i = 1; x = 0; y = 0; d = 0

    while i <= size**2:

        place[x][y] = i
        i+=1

        x += dx[dr[d]]
        y += dy[dr[d]]

        if x < 0 or y < 0 or x >= size or y >= size or place[x][y] != 0:        
            x -= dx[dr[d]]
            y -= dy[dr[d]]

            d= (d+1)%4

            x += dx[dr[d]]
            y += dy[dr[d]]
    
    result = f'#{T+1}\n'
    
    for f in range(len(place)):        
        for s in range(len(place[f])):
            result += f'{place[f][s]} '
        
        if f < len(place)-1:
            result += '\n'


    
    print(result)

            


    


