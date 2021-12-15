import numpy as np
from PIL import Image

fruits = np.load('fruits_300.npy')
# fruits=np.load('c:\outputNpy\images.npy')
for index, fruit in enumerate(fruits):
    image = Image.fromarray(fruit)
    image.save('pic'+str(index)+'.png')
    # image.save('c:\outputNpy\pic'+str(index)+'.png')
