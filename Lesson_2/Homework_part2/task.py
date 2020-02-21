# Пользователь вводит строку. Разрежьте её на две части – равные, если длина строки чётная, а
# если длина строки нечётная, то длина первой части должна быть на один символ больше.
# Переставьте эти две части местами, результат запишите в новую строку и выведите на экран.

ask = input("Enter something please: \n")
while len(ask) <= 1:
    ask = input("Enter something please: \n")

if len(ask) % 2 == 0:
    print(ask[int(len(ask) / 2):],
          ask[:int(len(ask) / 2)], sep='')
else:
    print(ask[int(len(ask) // 2 + 1):],
          ask[:int(len(ask) // 2 + 1)])