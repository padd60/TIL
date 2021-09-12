def cal(a,b):
  return a-b

result = cal(b=30,a=1);

print(result) # -29
# python은 다른 언어와는 함수의 인차위치를 신경쓰지않고 인자이름을 선언한뒤 값을 넣어주면 알아서 위치로 찾아들어간다는 장점이 있음

def sayHello(name, age):
    return 'hello my name is ' + name + ' and ' + age + 'years old'

result2 = sayHello('star', '25');

print(result2)

def sayHello2(name, age):
    return f'hello my name is {name} and {age}years old'

result3 = sayHello2('moon', '23');

print(result3)
# pyhton은 변수를 문자열에 사용하기 위해 출력값 앞에 f라는 format의 약자를 붙혀주고
# 변수를 {}로 묶어주어 사용한다.

def sayHello3(name, age, come, like):
    return f'hello my name is {name} {age}years old from {come} and l like {like}'

result4 = sayHello3(name='moon',age=23,come='korea',like='movie');

print(result4)
# 인자가 여러새 존재할 때 파이썬의 키이름 인자는 빛을 발한다.