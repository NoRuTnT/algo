cro_alphabet = ['c=', 'c-', 'dz=','d-', 'lj','nj', 's=', 'z=']
str = input()

for i in cro_alphabet:
    if i in str:
        str = str.replace(i,"*")
print(len(str))