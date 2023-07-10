n,m = map(int,input().split())
list1 = [a for a in range(1,n+1)]
for _ in range(m):
    i,j = map(int,input().split())
    list1[i-1], list1[j-1] = list1[j-1], list1[i-1]
for b in list1:
    print(b, end=" ")