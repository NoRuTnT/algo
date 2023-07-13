word = input().lower()
lst = list(set(word))
count_list = []
for i in lst:
    count_list.append(word.count(i))
if count_list.count(max(count_list)) >= 2:
    print("?")
else:
    a = count_list.index(max(count_list))
    print(lst[a].upper())
