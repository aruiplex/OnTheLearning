# Math in Python

There are 3 main libs in python:

1. matplotlib.pyplot: to plot function images.
2. numpy: more useful math data structure and convenient math calculation.
3. scipy: more math function (as far as I know, i am new)

Example 1:

The basic usage in _numpy_ and _pyplot_

```python
import matplotlib.pyplot as plt
import numpy as np

# processed data to plot
x_2a = [0.0, 59.0, 135.0, 200.0, 220.0, 308.0, 490.0]
y_2a = [0.0, 0.2, 0.6, 0.7, 1.2, 1.3, 1.7]
x_2b = [0.0, 100.0, 212.0, 298.0, 415.0, 528.0, 642.0]
y_2b = [0.0, 1.1, 1.9, 2.7, 3.5, 4.2, 5.0]
x_4 = [0.0, 39.7, 102.2, 136.3, 160.0, 198.4, 226.5]
y_4 = [0.0, 5.8, 11.7, 17.6, 23.4, 29.3, 35.2]

# plotfit to fit discrete data to a polynomial. The last parameter is the high power item.
(coeff, bias) = np.polyfit(x_4, y_4, 1)
x_4c = np.arange(0, 227, 1)

# numpy array which can directly used in math operations (like multiply and sum). which is not support in original python data structure.
y_4c = coeff*x_4c + bias
print(f"coeff of a: {coeff}, bias of a: {bias}")
# can plot multiple functions in one image, or use multiple times of plot in a image (in following examples).
plt.plot(x_4, y_4, "r1", x_4c, y_4c, "b")
plt.grid()
plt.title("Figure: Stress against strain")
plt.xlabel('stress $(kg/m^2)$')
plt.ylabel('strain $(\times 10^{-4})$')
plt.show()

```

Example 2:

numpy array can also calculate in a python funciton and return values.

```python

import numpy as np
import matplotlib.pyplot as plt


def strain(y):
    return 4*6.27*0.001*y/0.2**2


e1 = [0.0, 39.7, 102.2, 136.3, 160.0, 198.4, 226.5]
m1 = np.array(0, 3, 0.5)
e2 = np.array([0.0, 100.0, 212.0, 298.0, 415.0, 528.0, 642.0])

epsilon = strain(e2)
print(list(epsilon.round()))
print(list(e2.round()))
(coeff, bias) = np.polyfit(e1, epsilon, 1)
y_c = np.arange(0, 642, 1)
e_c = coeff*y_c
plt.plot(e2, epsilon, "r1", y_c, e_c)
print(f"coefficient: {coeff}, bias: {bias}")
plt.grid()
plt.title("Figure: strain against y")
plt.xlabel('$y(\mu m)$')
plt.ylabel('strain')
plt.show()

```

Example 3:

Bessel funciton in scipy and plot legend(图例).

```python
import numpy as np
import matplotlib.pyplot as plt
import scipy.special as sp

# generate a np array
x = np.arange(0, 20, 0.1)
bessel_index = [0, 1, 2, 3, 4, 5]
for i in bessel_index:
    y = sp.jv(i, x)
    # repeatly invoke *plot* and draw them to a image with a label. Automatically picked different colors in different lines.
    plt.plot(x, y, label=f"$\\beta$={i}")
    plt.grid()
    plt.legend()
plt.show()

```

The output:
![image-20210503161805827](image/image-20210503161805827.png)
