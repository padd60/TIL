import matplotlib.pyplot as plt
import pandas as pd
import numpy as np

df = pd.read_csv('age2.csv', encoding='cp949', index_col=0)
df = df.div(df['총인구수'], axis=0)  # 1 │ ➊ 전체 데이터를 총인구수로 나눠서 비율로 변환
del df['총인구수'], df['연령구간인구수']  # 1 │ ➋ 총인구수, 연령구간인구수 열 삭제

name = input('원하는 지역의 이름을 입력해주세요 : ')  # 2 │ 지역 이름 입력
a = df.index.str.contains(name)  # 3 │ 해당 행을 찾아서 해당 지역의 인구 구조를 저장
df2 = df[a]
df2

plt.rc('font', family='NANUMGothic')
# df2.T.plot()
# plt.show()

# 4 │ ➊ 궁금한 지역 A의 인구 비율에서 B의 인구 비율을 뺀다.
x = df.sub(df2.iloc[0], axis=1)
# 4 │ ➋ A의 인구 비율에서 B의 인구 비율을 뺀 값의 제곱 값을 모두 더한다.
y = np.power(x, 2)
z = y.sum(axis=1)

i = z.sort_values().index[:5]  # 4 │ ➌ 그 차이가 가장 작은 지역 5곳을 찾는다.

df.loc[i].T.plot()   # 4 │ ➍ 결과를 꺾은선 그래프로 보여준다.
plt.show()
