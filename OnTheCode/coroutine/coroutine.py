import time
import asyncio
import urllib.request


async def fun3(a):
    await a()


async def fun1():
    print("1 start")
    time.sleep(1)
    print("1 end")
    return 1


async def fun2():
    print("2 start")
    time.sleep(1)
    r = fun1()
    print(r)


# fun2()

asyncio.run(fun2())
