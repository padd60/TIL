
# args, kwargs
def plus(a, b, * args, **kwargs):
    print(args)  # (1, 1, 2, 1, 1, 1)
    print(kwargs)  # {'hello': True, 'aa': True, 'asdda': True, 'ff': True}
    return a + b


plus(1, 1, 1, 1, 2, 1, 1, 1, hello=True, aa=True, asdda=True, ff=True)

"""
args = position argument
함수의 파라미터 이상으로 입력하고 싶을 때 사용
무한으로 사용하고 싶을때 *args를 인자로 넣어줌
kwargs = keyword argument
xxx = yyy 와 같은 a=b 형태의 인자를 keyword argument라고 부른다
무한으로 사용하고 싶을때 **kwargs를 인자로 넣어준다
"""


def sum(*args):
    result = 0
    for number in args:
        result += number
    print(result)


sum(1, 2, 3, 3, 3, 2, 1, 1, 2, 3, 2, 2, 1, 3, 3, 4, 4, 1, 2, 1, 1, 1, 1, 1, 1)
# 49


# OOP(Object Orient Programming)
class Car():
    # wheels = 4
    # doors = 4
    # windows = 4
    # seats = 4
    # 생성자 함수 사용해보기
    def __init__(self, *args, **kwargs):
        # print(kwargs) # {'color': 'gray', 'price': '$70'}
        self.wheels = 4
        self.doors = 4
        self.windows = 4
        self.seats = 4
        self.color = kwargs.get('color', 'black')
        self.price = kwargs.get('price', '$20')

    def start(self):
        # print(self) # <__main__.Car object at 0x7f8c701f2a90>
        print(self.color)  # Super Red
        print('I started')

    def __str__(self):
        return f'Car with {self.wheels}wheels'


porche = Car()
porche.color = 'Super Red'
porche.start()

print(porche.windows)  # 4
print(porche.color)  # Super Red

ferrari = Car()
ferrari.color = 'Yellow'

mini = Car()
mini.color = 'White'

"""
파이썬은 메서드를 호출할때 다른 언어와 달리 인자를 주지 않으면 인스턴스로 부른 자기자신 즉, 객체를 인자로 넣어서 작동한다.
때문에 메서드에 인자가 비어있으면 보통 self라고 주는 이유가 자기자신을 넣기 때문이다.
그래서 위 Car 클래스 내 메서드와 같이 self.변수명으로 클래스 내 선언한 변수에 접근이 가능하다.
"""

print(dir(Car))  # Class 내 모든 property를 출력
"""
['__class__', '__delattr__', '__dict__', '__dir__', '__doc__', '__eq__', '__format__', 
'__ge__', '__getattribute__', '__gt__', '__hash__', '__init__', '__init_subclass__', 
'__le__', '__lt__', '__module__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', 
'__repr__', '__setattr__', '__sizeof__', '__str__', '__subclasshook__', '__weakref__', 
'doors', 'seats', 'start', 'wheels', 'windows']

위 프로퍼티 중 __str__를 오버라이드(재정의)하여 내가 원하는 대로 바꾸어 메서드 정의
"""

print(porche)
# 오버라이드 전 <__main__.Car object at 0x7fb4e819bfd0>
# 오버라이드 후 Car with 4wheels

benz = Car(color='gray', price='$70')
print(benz.color, benz.price)  # gray $70

bmw = Car()
print(bmw.color, bmw.price)  # black $20 기본 세팅 값이 나옴


# class 상속
class Convertible(Car):
    def __init__(self, **kwargs):
        # 부모 메서드 접근해 호출
        super().__init__(**kwargs)
        self.time = kwargs.get('time', 10)

    def take_off(self):
        return 'taking off'

    # 부모 클래스의 메서드 오버라이드
    def __str__(self):
        return f'Car with no roof'


lamborgini = Convertible(color='orange', price='$120')
print(lamborgini.color, lamborgini.price)  # orange $120
print(lamborgini.take_off())  # taking off
print(lamborgini.wheels)  # 4
print(lamborgini)  # Car with no roof
print(lamborgini.time)  # 10
