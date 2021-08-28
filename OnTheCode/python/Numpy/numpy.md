# Numpy

Numpy is a most famous Python lib. Write by C++. Many of these computed lib is written by C++.





## ndarray

The most interesting thing in Numpy is the `ndarray`. The most elegant array I have been found.



It overload the operator `*`, therefore it can be written as 

```python
x = np.asndarray([0.0, 59.0, 135.0, 200.0, 220.0, 308.0, 490.0])
y = coeff*x + bias
```



The append operation in the `ndarray` is:



```python
arr = np.append(arr, item)

```

  







##### Numpy array slice

Due to the high dimension array and get sub-array from different direction.

```python
>>> arr = [
    [
     	[1, 2],
     	[3, 4]
    ],
    [
        [5, 6],
        [7, 8]
    ],
    [
        [9,10],
        [11,12]
    ]
]
>>> narr = np.array(arr)
>>> narr.ndim
3
>>> narr[:,:,0]
array([[ 1,  3],
       [ 5,  7],
       [ 9, 11]])

```

`:` is used to slice array, as the placeholder.

