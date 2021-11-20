# [Pointers vs. values in parameters and return values](https://stackoverflow.com/questions/23542989/pointers-vs-values-in-parameters-and-return-values)

常见的话题，到底应该传什么东西。



- 如果需要改变，那只能是pointer，像是一些大的结构体，用pointer

- Slices, maps, channels, strings, function values, and interface values 在内部就已经在用pointer了，直接传值就好了。

reference:

[1] https://github.com/golang/go/wiki/CodeReviewComments#receiver-type

