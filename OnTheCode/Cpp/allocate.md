# Allocate





Objects on the stack have the really neat property that the memory that backs them is automatically freed at the end of that stack frame (e.g. when the function returns.) C++ extends this concept by **also** calling destructors for all stack objects **whenever** they fall out of scope (i.e. they're still freed in the case that an exception is thrown before the function returns.) Since this makes memory management dead simple, and memory management errors have the frustrating combination of being easy to make and hard to detect, stack allocation should be preferred whenever it is feasible.

The downside of stack-allocated objects is...well...they're deleted when the function returns. Sometimes there are legitimate reasons to want the object to live longer. In those cases, you have no choice but to allocate from the heap.

Another point to consider is that stack allocation *pretty much* has to be a size that is known at the time the software is compiled (but see alloca function available on some platforms.) There are a ton of real world scenarios where you won't know until the program is running how much memory you need. Take for example an address book application. If I am coding such an application, I obviously have no idea how many people the end user is going to want in their address book. The user has to tell the program this information. In this case, you need to have dynamically allocated memory, so you're again looking at heap allocation.



---



Use automatic (stack) allocation whenever the function scope - or the scope of a control block such as a `for`, `while`, `if` etc. inside the function - is a good match for the lifetime the object needs. That way, if the object owns/controls any resources, such as dynamically allocated memory, file handles etc. - they will be freed during the destructor call as that scope is left. (Not at some unpredictable later time when a garbage collector winds up).

Only use `new` if there's a clear need, such as:

- needing the object to live longer than the function scope,
- to hand over ownership to some other code
- to have a container of pointers to base classes that you can then process polymorphically (i.e. using virtual dispatch to derived-class function implementations), or
- an especially large allocation that would eat up much of the stack (your OS/process will have "negotiated" a limit, usually in the 1-8+ megabyte range)
  - if this is the only reason you're using dynamic allocation, and you do want the lifetime of the object tied to a scope in your function, you should use a local `std::unique_ptr<>` to manage the dynamic memory, and ensure it is released no matter how you leave the scope: by `return`, `throw`, `break` etc.. (You may also use a `std::unique_ptr<>` data member in a `class`/`struct` to manage any memory the object owns.)

Mathieu Van Nevel comments below about C++11 move semantics - the relevance is that if you have a small management object on the stack that controls a large amount of dynamically allocated (heap) memory, move semantics grant extra assurances and fine-grained control of when the management object hands over its resources to another management object owned by other code (often the caller, but potentially some other container/register of objects). This handover can avoid data on the heap being copied/duplicated even momentarily. Additionally, *elision* and *return-value-optimisation* often allow nominally automatic/stack-hosted variables to be constructed directly in some memory they're eventually being assigned/returned-to, rather than copied there later.





Reference:

https://stackoverflow.com/questions/33510756/objects-on-a-stack-vs-objects-on-a-heap-in-c

https://stackoverflow.com/questions/36646493/c-stack-vs-heap-allocation?answertab=active#tab-top