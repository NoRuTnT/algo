import sys
a,b = map(str,sys.stdin.readline().split())
A = int(a[::-1])
B = int(b[::-1])
if A > B:
    print(A)
else:
    print(B)