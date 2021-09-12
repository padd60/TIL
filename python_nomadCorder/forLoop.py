days = ('mon','thus','weds','thur','fri')

for week in days:
  print (week);
# week은 for문이 실행될 때 자동으로 생성되는 변수이다.

for string in 'korea':
  print(string);
# python은 문자도 배열로 받아서 문자열로 나타낸다.

for week in days:
  if week is 'weds':
    break
  else:
    print(week);
# for문에 조건을 주고 만족시 종료시키기 위해서는 break를 사용한다.