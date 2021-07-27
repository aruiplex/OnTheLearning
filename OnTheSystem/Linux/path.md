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

