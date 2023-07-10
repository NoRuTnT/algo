import sys
n = int(sys.stdin.readline())
num_lst = [int(sys.stdin.readline()) for _ in range(n)]
check = [0]*8001
final_count = 0
mode_check = []
for i in num_lst:
    if i == 0:
        check[4000] += 1
    elif i < 0:
        check[abs(abs(i)-4000)] += 1
    else:
        check[i+4000] += 1
for i in range(8001):
    if check[i] > final_count:
        final_count = check[i]
        mode_check = []
        mode_check.append(i)
    elif check[i] == final_count:
        mode_check.append(i)
if len(mode_check) == 1:
    mode = mode_check[0]-4000
if len(mode_check) > 1:
    mode = mode_check[1]-4000
avg = round(float(sum(num_lst))/n)
new_lst = sorted(num_lst)
median = new_lst[(n//2)]
num_range = max(num_lst)-min(num_lst)
print(avg, median, mode, num_range, sep="\n")
