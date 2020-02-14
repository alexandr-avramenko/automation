# Определите является ли строка записью числа

ask = input("Enter only digits please: " + "\n")
if ask.isdigit():
    print("Great! The string contains only digits!")
else:
    print("Something went wrong! The string contains at least one character" + "\n")

# Посчитайте сколько у вас пробелов в строке.
# ВОПРОС: почему при методе print без явного приведения переменной типу 'str' программа не работает? (строка 14)

ask2 = input("Enter any sentence please: " + "\n")
n = ask2.count(' ')
print("The string contains the " + str(n) + " " + "spaces" + "\n")

# Посчитайте сколько у вас символов точки '.' в строке

dots = input("Enter any sentence please: " + "\n")
x = dots.count('.')
print("The string contains " + str(x) + " " + "dots" + "\n")

# Создайте строку "Homework".
# Преобразуйте её в строку длиной 100 символов, посередине которой исходное слово,
# а с обоих сторон строка заполнена пробелами. Выведите её на экран.

str = "Homework"
print(str.center(100))

# Сделайте первые буквы слов строки большими (upper case)

s = input("Enter several words please: " + "\n")
print(s.title())