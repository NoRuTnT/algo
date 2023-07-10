import sys
t = int(sys.stdin.readline())
for _ in range(t):
    r,s = map(str, sys.stdin.readline().strip().split())
    for i in s:
        print(i*int(r), end="")
    print()