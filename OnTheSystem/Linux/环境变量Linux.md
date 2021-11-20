# 环境变量

**环境**变量的环境，就是指当前的这个shell。

每一个进程都能拿到**这个**shell里的变量，也就是说换一个shell这些环境变量就没有了。

What is path?

You want to system immediately know the where are the programs (the executable files) you want to run.

For example, you input 

```bash
$ java --version
```

The terminal will know where is Java, and where should it pass the arguments to the Java. 

You need PATH. It tells the system, all the program location. It should be a folder (directory) to let terminal search in.



This is a difficult way to understand path. It consumed me three years...



When I use Windows, it has a GUI interface to configuration the *path*. All the thing you need to do is click add button and input the position of program you want to add. And all the PATHs you can directly browse in GUI.



In the Linux, it should be:

```bash
$ echo $PATH
```

To append path, do some modify in `.bashrc`:

```bash
export PATH = " $PATH :/<target_directory>"
```



## Temporary

**仅**在当前的shell里设定环境变量，但是从这个shell里起来的进程都拿不到。

```bsh
VARNAME="my value"
```

不仅在当前的shell里能用，每一个从该shell里起来的进程都可以接触到的环境变量。

```bsh
export VARNAME="my value"      # shorter, less portable version
```

## Permanently

To set it **permanently** for all future bash sessions add such line to your `.bashrc` file in your `$HOME` directory.

To set it permanently, and **system wide** (all users, all processes) add set variable in /etc/environment:

```bsh
sudo -H gedit /etc/environment
```

This file only accepts variable assignments like:

```bsh
VARNAME="my value"
```

Do not use the `export` keyword here.

You need to logout from current user and login again so environment variables changes take place.



记着用`export`就行了。



reference：

[1] https://unix.stackexchange.com/questions/71144/what-do-the-bash-builtins-set-and-export-do

[2] https://askubuntu.com/questions/58814/how-do-i-add-environment-variables