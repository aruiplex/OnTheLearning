Abstract data types

----

User defined data type = abstract data type

The abstract data types is important on operations: the programmer can ignore how the implementation.

> It is a characteristic of *encapsulation*, which is a perspective of layering. Ignore the detail and only care about the API. 



Classifying the Types and Operations:

1. mutable.
2. immutable.

Sometimes, there provide both like `String` and `StringBuilder`.



Operations

---

There has **Operation** in **Type**.

1. **Creators**

   Create a new object. Cannot take the object which being constructed as parameter.       The *builder* is a kind of creator.

   `t* -> T`

2. **Producers**

   Create new objects from old objects, which are the same type. `String.Concat()` is a producer.

   `T+, t* -> T`

3. **Observers**

   Use this object and return another type object. *Getters* are observers. 

   `T+, t* -> t`

4. **Mutators**

   Make changes to objects. `List.add()` is a mutators.

   `T+, t* -> void | t | T`

T: this type;

t: other type.

