t = int(input())
for _ in range(t):
    check = [0]*101
    final_count = 0
    many_num = 0
    num = int(input())
    lst = list(map(int, input().split()))
    for i in lst:
        check[i] += 1
    for i in range(101):
        if check[i] >= final_count:
            final_count = check[i]
            many_num = i
    print(f"#{num} {many_num}")




