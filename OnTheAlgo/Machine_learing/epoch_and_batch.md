In the neural network terminology:

- one **epoch** = one forward pass and one backward pass of *all* the training examples
- **batch size** = the number of training examples in one forward/backward pass. The higher the batch size, the more memory space you'll need.
- number of **iterations** = number of passes, each pass using [batch size] number of examples. To be clear, one pass = one forward pass + one backward pass (we do not count the forward pass and backward pass as two different passes).

Example: if you have 1000 training examples, and your batch size is 500, then it will take 2 iterations to complete 1 epoch.

FYI: [Tradeoff batch size vs. number of iterations to train a neural network](https://stats.stackexchange.com/q/164876/12359)





reference:

https://stats.stackexchange.com/questions/153531/what-is-batch-size-in-neural-network

