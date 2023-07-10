import sys
n = int(sys.stdin.readline())
num_lst = list(map(int, sys.stdin.readline().split()))
max_point = max(num_lst)
fake_lst = [i/max_point*100 for i in num_lst]
avg = sum(fake_lst)/n
print(avg)