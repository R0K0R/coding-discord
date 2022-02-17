input1 = input("factorial >")
result = int(input1)

for i in range(int(input1)-1, 1, -1):
    result = result * i

print(result)