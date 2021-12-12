import matplotlib.pyplot as plt
import random
import csv
import numpy as np

# f = open("seoul.csv", encoding='utf-8')
# data = csv.reader(f)
# next(data)
# max_temp = -999
# max_date = ""
# for row in data:
#     if row[-1] == "":
#         row[-1] = -999
#     row[-1] = float(row[-1])
#     if max_temp < row[-1]:
#         max_date = row[0]
#         max_temp = row[-1]

# f.close()

# print('서울 기온 가장 높은 떄는', max_date + '로', max_temp, '도 였습니다.')
# print(max_temp, max_date)

dice = []
for i in range(1000000):
    dice.append(random.randint(1, 6))

# plt.hist(dice, bins=6)
# plt.show()


f = open("seoul.csv", encoding='utf-8')
data = csv.reader(f)
result = []
next(data)
for row in data:
    if row[-1] != "":
        result.append(float(row[-1]))

f.close()

# plt.boxplot(result)
# plt.show()


# f = open('age.csv')
# data = csv.reader(f)
# next(data)
# home = []                       # 입력받은 지역의 데이터를 저장할 리스트 생성
# name = input('인구 구조가 알고 싶은 지역의 이름(읍면동 단위)을 입력해주세요: ')
# for row in data:
#     if name in row[0]:          # 입력받은 지역의 이름이 포함된 행 찾기
#         for i in row[3:]:       # 3번 인덱스 값부터 슬라이싱
#             home.append(int(i))  # 입력받은 지역의 데이터를 home에 저장
# print(home)                      # home에 저장된 데이터 출력

# f = open('age.csv')
# data = csv.reader(f)
# next(data)
# home = []
# name = input('인구 구조가 알고 싶은 지역의 이름(읍면동 단위)을 입력해주세요: ')
# for row in data:
#     if name in row[0]:
#         home = np.array(row[3:], dtype=int)
# print(home)

# plt.rc('font', family='NANUMGothic')
# plt.title(name+' 지역의 인구 구조')
# plt.plot(home)
# plt.show()

f = open('age.csv')
data = csv.reader(f)
next(data)
home = []
data = list(data)
name = input('인구 구조가 알고 싶은 지역의 이름(읍면동 단위)을 입력해주세요 : ')
mn = 1           # 최솟값을 저장할 변수 생성 및 초기화
result_name = ''  # 최솟값을 갖는 지역의 이름을 저장할 변수 생성 및 초기화
result = 0       # 최솟값을 갖는 지역의 연령대별 인구 비율을 저장할 배열 생성 및 초기화
for row in data:
    if name in row[0]:
        home = np.array(row[3:], dtype=int)/int(row[2])
for row in data:
    away = np.array(row[3:], dtype=int)/int(row[2])
    s = np.sum((home-away)**2)
    if s < mn and name not in row[0]:
        mn = s
        result_name = row[0]
        result = away

plt.rc('font', family='NANUMGothic')
plt.title(name+' 지역과 가장 비슷한 인구 구조를 가진 지역')  # 그래프 제목 설정
plt.plot(home, label=name)             # home 값을 그리는 그래프 레이블 설정
plt.plot(result, label=result_name)    # result 값을 그리는 그래프 레이블 설정
plt.legend()                           # 범례 표기
plt.show()
