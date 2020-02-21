# Пользователь вводит строку
ask = input("Enter some words please: \n")
while len(ask) <= 2:
    ask = input("Enter some words please: \n")

# Сначала выведите третий символ этой строки
print("The 3rd symbol in the string is:", ask[2])

# Во второй строке выведите предпоследний символ этой строки
print("The pre-last symbol in the string is:", ask[-2])

# В третьей строке выведите первые пять символов этой строки
print("The first five characters in the string is:", ask[:5])

# В четвертой строке выведите всю строку, кроме последних двух символов
print("All string length without two last characters:", ask[:-2])

# В пятой строке выведите все символы с четными индексами (считая, что индексация
# начинается с 0, поэтому символы выводятся, начиная с первого символа).
print("Odd symbols:", ask[::2])

# В шестой строке выведите все символы с нечетными индексами, то есть начиная со второго символа строки.
print("Even symbols:", ask[1::2])

# В седьмой строке выведите все символы в обратном порядке.
print("Reverse:", ask[::-1])

# В восьмой строке выведите все символы строки через один в обратном порядке, начиная с последнего.
print("Reverse with 1 step:", ask[-1::-2])

# В девятой строке выведите все символы строки через один в обратном порядке, начиная с предпоследнего
print("Reverse with 1 step, starts from pre-last:", ask[-2::-2])

# В десятой строке выведите все символы в обратном порядке без первого и последнего элемента
print("The whole string without the first and the last symbols:", ask[-2:0:-1])

# Ну, и напоследок выведите длину данной строки
print("The length of the string =", len(ask))

# INDEX ERROR