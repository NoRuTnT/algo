import sys
t = int(sys.stdin.readline())
for _ in range(t):
    a = sys.stdin.readline().strip()
    print(a[0]+a[-1])