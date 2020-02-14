import math

# Вычислите длину гипотенузы в прямоугольном треугольнике со сторонами 158 и 971
a = 158
b = 971
c = math.sqrt(a ** 2 + b ** 2)
print("Sides of the triangle: " + "\n"
      + "cathet 'a' - " + str(a) + ", " + "\n"
      + "cathet 'b' - " + str(b) + ", " + "\n"
      + "hypotenuse 'c' - " + str(c))

# или

print("hypotenuse: " + str(math.hypot(a, b)))

# Дано двузначное число. Найдите число десятков в нем

ask = int(input("Enter any double digit please:" + "\n"))
while ask < 10:
    print("Error: You might entered single digit. Try again please.")
    ask = int(input("Enter any double digit please:" + "\n"))

i = 0
while ask >= 10:
    ask -= 10
    i += 1
print("Entered digit contains " + str(i) + " tenths")

# Дано трёхзначное число. Найдите сумму его цифр.

sum = 0
n = input("Enter any three-digit number please:" + "\n")
while int(n) <= 100 or int(n) >= 1000:
    n = input("Enter any three-digit number please:" + "\n")

for i in n:
    sum += int(i)

print("Sum of the entered digits is: " + str(sum))

# Дано целое число n. Выведите следующее за ним чётное число

n = input("Enter any number please:" + "\n")
while int(n) % 2 != 0:
  n += 1

print ("The next integer number is: " + str(n))

# Дано положительное действительное число X. Выведите его дробную часть

y = float(input("Enter a float number please: "))
x = str(math.modf(y)[0])
print("The fractional part = " + x[2:])

# Дано положительное действительное число X. Выведите его первую цифру после десятичной точки

num = str(input("Enter a positive float number please: ") + "\n")
i = 0
for elem in num:
  i += 1
  if elem == ".":
    print (num[i])
    break