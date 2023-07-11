import string
import sys
word = sys.stdin.readline().strip()
alphabet = [i for i in string.ascii_lowercase]
for a in alphabet:
    if a in word:
        print(word.index(a), end=" ")
    else:
        print(-1,end=" ")