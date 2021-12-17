from PIL import Image
from sklearn.cluster import KMeans
import numpy as np

img = np.load(
    '/Users/kimjunghwan/TIL/machine_learning_workspace/outputNpy/images.npy')
img_2d = img.reshape(-1, 150*150)

km = KMeans(n_clusters=2, random_state=42)
km.fit(img_2d)

print(np.unique(km.labels_, return_counts=True))

for index, fruit in enumerate(img[km.labels_ == 1]):
    image = Image.fromarray(fruit)
    # image.save('pic'+str(index)+'.png')
    image.save(
        '/Users/kimjunghwan/TIL/machine_learning_workspace/outputNpy/pic'+str(index)+'.png')
