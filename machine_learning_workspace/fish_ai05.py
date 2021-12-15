from sklearn.model_selection import GridSearchCV
from sklearn.model_selection import StratifiedKFold
from sklearn.model_selection import cross_validate
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import train_test_split
import pandas as pd
import numpy as np

wine = pd.read_csv('https://bit.ly/wine-date')

# print(wine.head())
# print(wine.info())


data = wine[['alcohol', 'sugar', 'pH']].to_numpy()
target = wine['class'].to_numpy()


train_input, test_input, train_target, test_target = train_test_split(
    data, target, test_size=0.2, random_state=42)


sub_input, val_input, sub_target, val_target = train_test_split(
    train_input, train_target, test_size=0.2, random_state=42)

# print(sub_input.shape, val_input.shape)


dt = DecisionTreeClassifier(random_state=42)
dt.fit(sub_input, sub_target)

print(dt.score(sub_input, sub_target))
print(dt.score(val_input, val_target))

scores = cross_validate(dt, train_input, train_target)
print(scores)

print(np.mean(scores['test_score']))


scores = cross_validate(dt, train_input, train_target, cv=StratifiedKFold())
print(np.mean(scores['test_score']))

splitter = StratifiedKFold(n_splits=10, shuffle=True, random_state=42)
scores = cross_validate(dt, train_input, train_target, cv=splitter)
print(np.mean(scores['test_score']))


params = {'min_impurity_decrease': [0.0001, 0.0002, 0.0003, 0.0004, 0.0005]}

gs = GridSearchCV(DecisionTreeClassifier(random_state=42), params, n_jobs=-1)

gs.fit(train_input, train_target)

print(gs.best_params_)

dt = gs.best_estimator_
print(dt.score(train_input, train_target))


params = {'min_impurity_decrease': np.arange(0.0001, 0.001, 0.0001),
          'max_depth': range(5, 20, 1),
          'min_samples_split': range(2, 100, 10)
          }

gs = GridSearchCV(DecisionTreeClassifier(random_state=42), params, n_jobs=-1)
gs.fit(train_input, train_target)

print(gs.best_params_)
print(np.max(gs.cv_results_['mean_test_score']))
