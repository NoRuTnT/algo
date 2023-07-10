num_lst = [int(input()) for _ in range(10)]
avg = sum(num_lst)//10
check = [0]*99
final_count = 0
many_num = 0
for i in num_lst:
    check[(i//10)-1] += 1
for i in range(99):
    if check[i] >= final_count:
        final_count = check[i]
        many_num = (i+1)*10
print(avg)
print(many_num)

