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

`:` is used to slice array, as the placeholder. It means all items are considered into slice operation. A number means only consider this index in the slice operation.

The order of slice operation `[:,:,0]` is descend dimension. In the last example, the first `:` is `ndim=3` array operation.









##### Transpose

When you transpose a 1-dimension matrix

```python
>>> arr = np.arange(10)
>>> arr
array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
>>> arr.T
array([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
```

You find this still a 1d matrix. Because 1-d matrix transpose still a 1d matrix. It will not cause any impact.

Therefore, it has two ways to make it become a column vector.

reshape:

```python
>>> arr.reshape(-1,1)
array([[0],
       [1],
       [2],
       [3],
       [4],
       [5],
       [6],
       [7],
       [8],
       [9]])
>>> np.array([1,2,3,4,5,6])
array([1, 2, 3, 4, 5, 6])

# other way to add one dimension to transpose.
>>> np.array([1,2,3,4,5,6])[np.newaxis]
array([[1, 2, 3, 4, 5, 6]])
>>> np.array([1,2,3,4,5,6])[np.newaxis].T
array([[1],
       [2],
       [3],
       [4],
       [5],
       [6]])

>>> np.array([1,2,3,4,5])[:,np.newaxis]
array([[1],
       [2],
       [3],
       [4],
       [5]])
>>> np.array([1,2,3,4,5])[np.newaxis,:]
array([[1, 2, 3, 4, 5]])

```



##### Dimension

This is a difficult topic to get into Numpy.

```python
>>> np.arange(0,5)
array([0, 1, 2, 3, 4])
>>> np.arange(0,5)[:,np.newaxis]
array([[0],
       [1],
       [2],
       [3],
       [4]])
>>> np.arange(0,5)[:,np.newaxis,np.newaxis]
array([[[0]],

       [[1]],

       [[2]],

       [[3]],

       [[4]]])

```

`np.newaxis` means add a new dimension into the array.

The `:` means a dimension.



##### Add array to high dimension array from any dimension

```python
>>> arr = np.arange(9)
>>> arr
array([0, 1, 2, 3, 4, 5, 6, 7, 8])
>>> arr.reshape((3,3))
array([[0, 1, 2],
       [3, 4, 5],
       [6, 7, 8]])
>>> a[:,-1]
array([2, 5, 8])

```

Array negative indexing means from right to left, and the positive indexing means from left to right. 

Negative numbers mean that you count from the right instead of the left. So, `list[-1]` refers to the last element, `list[-2]` is the second-last, and so on.

















