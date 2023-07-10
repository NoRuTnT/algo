number = []
for _ in range(9):
    number.append(int(input()))
a=max(number)
print(a)
print(number.index(a)+1)