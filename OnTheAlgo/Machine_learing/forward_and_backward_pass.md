The **"forward pass"** refers to calculation process, values of the output layers from the inputs data. It's traversing through all neurons from first to last layer.

A loss function is calculated from the output values.

And then **"backward pass"** refers to process of counting changes in weights (de facto *learning*), using gradient descent algorithm (or similar). Computation is made from last layer, backward to the first layer.

Backward and forward pass makes together one **"iteration"**.

------

During one iteration, you usually pass a subset of the data set, which is called **"mini-batch"** or **"batch"** (however, "batch" can also mean an entire set, hence the prefix "mini")

**"Epoch"** means passing the entire data set in batches.
One epoch contains *(number_of_items / batch_size)* iterations





reference:

https://stackoverflow.com/questions/36740533/what-are-forward-and-backward-passes-in-neural-networks