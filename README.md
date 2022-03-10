### Fixing Race Conditions with Atomic Objects

Expected time required: 10 min

Race conditions can occur when multiple threads try to access part of an application simultaneously. Atomic object
types use built-in synchronization to help prevent multiple threads from accessing an object at the same time.

The included class, `RaceCounter`, has a private `int` primitive called `counter`. When `startCounter()` is called,
an integer `countTo` is passed in that tells `RaceCounter` how high to count. The `counter` is then modified by that
number of threads that are run by an `ExecutorService`. Each of these threads is implemented as a lambda `Runnable`.
They each have a reference to the `counter` variable and access it directly to increment it by one. This is causing
race conditions to occur. You need to do the following to fix this:

* Change the type of `counter` to an Atomic type.
* Make adjustments to the lambda `Runnable` and to `getCounter` in order to support the use of an Atomic type.

In the `main` method of the `RaceCounterApp`, we've told `RaceCounter` to count up to 10,000. If you run the `main`
method before you make changes, you'll see that the output changes each time you run it.  

```
Counter value: 9992
...  
Counter value: 9892
...
Counter value: 9986
```

..etc. (Your individual outputs may be different from those shown)

Update the code so that the correct output is produced:  

```
Counter value: 10000
```

HINTS:
* [I changed the object type but now I am getting errors](hints/hint-01.md)
