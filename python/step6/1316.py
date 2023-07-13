import sys
t = int(sys.stdin.readline().strip())
point = t
for _ in range(t):
    word = sys.stdin.readline().strip()
    for i in range(0,len(word)-1):
        if word[i] == word[i+1]:
            pass
        elif word[i] in word[i+1:]:
            point -= 1
            break
print(point)