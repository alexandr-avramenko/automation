# Напишите программу, которая запрашивает ввод двух значений. Если хотя бы одно из них не
# является числом (любым), то должна выполняться конкатенация, т. е. соединение, строк. В
# остальных случаях введённые числа суммируются.

a = input("Enter the first value\n")
b = input("Enter the second value\n")

try:
    float(a)
    float(b)
except (ValueError):
    print(str(a)+str(b))
else:
    print("Sum of two numbers are", float(a) + float(b))