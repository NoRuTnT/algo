import sys
num_lst = [int(sys.stdin.readline())%42 for _ in range(10)]
new_lst = []
for i in num_lst:
    if i not in new_lst:
        new_lst.append(i)
print(len(new_lst))