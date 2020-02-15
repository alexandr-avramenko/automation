# Пользователь вводит целое число. Требуется определить, является ли год с данным номером високосным.
# Если год является високосным, то выведите YES, иначе выведите NO.
# Напомним, что в соответствии с григорианским календарём,
# год является високосным, если его номер кратен 4, но не кратен 100, а также если он кратен 400.

year = int(input("Enter a year please: " + "\n"))

while year > 9999:
    print("Error: You might entered a incorrect number. Try again please.")
    year = int(input("Enter a year please: " + "\n"))

if year % 4 == 0 and year % 100 != 0 or year % 400 == 0:
    print("YES")
else:
    print("NO")


# Даны три числа a, b, c.
# Определите, существует ли треугольник с такими сторонами.
# Если треугольник существует, выведите строку YES, иначе выведите строку NO.

a = float(input("Enter an 'a' side: "))
b = float(input("Enter an 'b' side: "))
c = float(input("Enter an 'c' side: "))

if a + b > c or b + c > a or a + c > b:
    print("YES")
else:
    print("NO")

# Дано три числа. Упорядочите их в порядке возрастания. Программа должна считывать три числа a, b, c,
# затем программа должна менять их значения так, чтобы стали выполнены условия a <= b <= c, затем программа выводит тройку a, b, c.

print("Enter 3 nums please:")

aa = int(input("Enter an 'a': "))
bb = int(input("Enter an 'b': "))
cc = int(input("Enter an 'c': "))

ss = [aa, bb, cc]
ss.sort()
print(ss)

# Даны три целых числа. Определите, сколько среди них совпадающих.
# Программа должна вывести одно из чисел: 3 (если все совпадают), 2 (если два совпадает) или 0 (если все числа различны).

print("Enter 3 nums please:")

first = int(input("a: "))
second = int(input("b: "))
third = int(input("c: "))

if first == second == third:
    print("3")
elif first == second or second == third or first == third:
    print("2")
else:
    print("0")