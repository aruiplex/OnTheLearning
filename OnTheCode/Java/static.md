# Static 关键字

这还是在学当时大二没学会的东西..

但是又代码经验之后, 这些东西好理解很多了.



### Variable layer perspective

这是我最爱的 [Java-tutorial](https://www.baeldung.com/java-static) 网站上的解释: 

> The keyword static indicates that the particular member belongs to a type itself, rather than to an instance of that type.

这里的`type`就是`class`了.

就是说不属于对象的类变量, 

```java
public class Student {
    int id;
    String name;
    static int totalNum = 0;
    Student(int id, String name) {
        this.id = id;
        this.name = name;
        totalNum++;
    }
}

```

 

if a field is declared **static**, then exactly a single copy of that field is created and shared among all instances of that class

static关键字的内存, 可以在不同实例之间共享, 并且只占用一块内存. 为什么要强调这个呢? 因为不同的类的对象会占用多块内存, 因为类变量是不同的, 但是static只占用一块



static variables go in a particular pool in JVM memory called `Metaspace`.

静态变量所在的内存是叫做 `metaspace`.



什么时候使用static呢?

1. 这个内存不属于对象,
2. 但是要在不同对象之间使用.



使用静态变量的时候, 虽然可以通过对象来查找这个静态变量, 但是最好还是用`class.staticMemory` 来操作静态变量.

```java

public class App {
    public static void main(String[] args) throws Exception {

        Student s0 = new Student(182314);
        System.out.println("s0.totalNum: " + s0.totalNum);
        System.out.println(s0);
        System.out.println("Student.totalNum: " + Student.totalNum);
    }
}

```



### Method layer perspective

静态方法一般用作:

1. 操作静态变量,
2. 工具类和辅助类
	
	> [Collections](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html) or [Math](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html) utility classes from JDK, [StringUtils](https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html) from Apache or [CollectionUtils](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/util/CollectionUtils.html) from Spring framework



static block

1. 静态变量初始化需要赋值, 并且需要一些逻辑
2. 静态变量赋值需要处理异常.





### Class layer perspective 

Java 内部类:

分为两种:

1. nested classes that are declared *static* are called **static nested classes** whereas,
2. nested classes that are non-*static* are called **inner classes**

也就是说, 分为静态嵌套类和内部类.



static nested classes behaved exactly like any other top-level class but enclosed in the only class which will access it, to provide better packaging convenience.

和别的类一样, 内部类和顶层的类一样, 但是只能由包裹着它的类访问, 提供封装的便利.



下面是一个很经典的单例对象

```java
public class Singleton  {    
    private Singleton() {}
    
    private static class SingletonHolder {    
        public static final Singleton instance = new Singleton();
    }    

    public static Singleton getInstance() {    
        return SingletonHolder.instance;    
    }
}
```



java没有静态的顶类.