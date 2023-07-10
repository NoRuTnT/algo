n = int(input())
list1 = list(map(int, input().split()))
a, b = min(list1), max(list1)
print(a,b,sep=" ")