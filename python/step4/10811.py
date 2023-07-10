n, m = map(int, input().split())
basket = [i for i in range(1, n + 1)]
for _ in range(m):
    i, j = map(int, input().split())
    new_basket = reversed(basket[i-1: j])
    basket[i-1:j] = new_basket
for a in basket:
    print(a, end=" ")
