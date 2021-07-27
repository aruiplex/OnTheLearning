# Key word `yield`



```python
def sequence():
    num = 0
    while True:
        x = yield num
        num = x + 1


gen = sequence()
print(next(gen))
print(gen.send(1000))
print(gen.send(100))
print(gen.send(10))
print(gen.send(0))
print(gen.send(10000))

```

`yield` keyword can store the generator state. Without `yield`, it should define other static variables to control and record the state.

There have two keyword in set.



`yield`

----

The feature of this keyword:

1. return present state value.
2. record the state for next state.

```python
def sequence():
    num = 0
    while True:
        yield num
        num += 1

```

The code will generate a infinite sequence with step equals 1. 



`send`

---

The feature of this keyword:

1. receive the value from caller.
2. store the value into the left side of `yield`



The meaning of `x = yield i`

---

It actually divide into 2 steps.  

```python
# return value
yield i
# |block here|
# won't continue until next() or send() is called
# and this is also the entry point of next() or send()
# receive value from send
X = the_input_of_send

```



When you use `send` and expression `yield` in a generator, you're treating it as a coroutine; a separate thread of execution that can run sequentially interleaved but not in parallel with its caller..

And the following two statement are equals:

1. `response = next(generator)`;
2. `response = generator.send(None)`



But the to start the generator, it should operate a `next()` at the start 





reference:

1. https://stackoverflow.com/questions/12637768/python-3-send-method-of-generators