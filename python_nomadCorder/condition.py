def plus(a, b):
    if type(b) is str or type(a) is not int:
      return 'this is not numbers';
    else:
      return a+b;

print(plus(10,20))
print(plus(10,'hello'))
print(plus('10','hello'))

# python은 if 조건문에서 조건뒤에 :로 줄을 나누고 들여쓰기를 통해 리턴문을 사용한다.
# is, is not은 파이썬에만 있는 기능으로 같다, 같지 않다를 나타낸다.