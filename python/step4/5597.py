import sys
num_lst = [int(sys.stdin.readline()) for _ in range(28)]
for i in range(1,31):
    if i not in num_lst:
        print(i)
