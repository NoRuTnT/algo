word = input().lower()
lst = list(set(word))
countlist = []
for i in lst:
    countlist.append(word.count(i))
if countlist.count(max(countlist)) > 1:
    print("?")
else:
    a = countlist.index(max(countlist))
    print(word[a].upper())