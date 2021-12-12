a = 10
a = -170
a = 10

print(a)

b = 10

print(b)

print(a/b)
print(a//b)
print(a**2)

a = 13

if a % 2 == 0:
    print("짝수")
else:
    print("홀수")


def oddEven(num):
    if num % 2 == 0:
        print("짝수")
    else:
        print("홀수")


oddEven(a)
oddEven(b)


def zegob(num, gob):
    print(num ** gob)


zegob(a, 3)
zegob(b, 3)

multiline = """여러줄 출력하는
중 이다 임
마 이렇게 끊
기니까 좀 킹
받지?
?"""

print(multiline)

arr = [1, 2, 3, 4, 5]

print(arr[-1])

word = "life is good"

print(word[-1])

print(word[0:4])

word2 = "20211210Rainy"

date = word2[:8]
weather = word2[8:]
year = word2[:4]
day = word2[4:8]

print(date, weather, year, day)

number = 10
dayday = "three"
print("I ate {0} apples, so I was sick for {1} days".format(number, dayday))

print("{0:<10}".format("정렬"))
print("{0:^10}".format("정렬"))
print("{0:>10}".format("정렬"))

str1 = "hobby"
print(str1.count("b"))

print(",".join(str1))


print(",".join(['기영이', '주식고수', '수퍼개미']))

print(str1.upper())

str2 = "    hello     "

print(str2.lstrip() + "python")
print(str2.rstrip() + "python")
print(str2.strip() + "python")

str3 = "life is good"
print(str3.split())

arr2 = [1, 2, 3, ['a', 'b', 'c']]

print(arr2[-1][0])

arr3 = [1, 2, 3, 4, 5, ]

print(arr3[:2])
print(arr3[2:])

del arr3[2:]

print(arr3)

arr3.insert(0, 4)

print(arr3)

money = True
if money:
    print('택시 ㄱㄱ')
else:
    print('걸어서 ㄱㄱ')

pocket = ['paper', 'cellphone']
card = True
if 'money' in pocket:
    print('택시 ㄱ')
elif card:
    print('택시 ㄱ')
else:
    print('걸어서 ㄱ')

ex = [(1, 2), (3, 4), (5, 6)]
for (first, last) in ex:
    print(first + last)


def add(a, b):
    return a+b


print(add(a, b))
print(add(a=5, b=5))

