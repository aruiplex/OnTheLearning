import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.print.event.PrintEvent;

import impl.TwoQueueStack;

/**
 * 思路: 连接一次之后, 如果 source 比 target 长, 要是还没有就是 -1. 要是 source 没有 target 长, 就继续连接,
 * 直到 source 比 target 长.
 */

public class Main {

    public static void main(String[] args) {

        String s0 = "hellow";
        String s1 = new String("hellow");
        System.out.println(s0.equals(s1));
    }
}
/**
 * } Syntax Error(s) __tester__.java:11: error: Illegal static declaration in
 * inner class __tester__.Main public static void main(String[] args) { ^
 * modifier 'static' is only allowed in constant variable declarations
 * __tester__.java:25: error: cannot find symbol
 * System.out.println(concatContain("ab", "baba"));; ^ symbol: method
 * concatContain(String,String) location: class __tester__ __tester__.java:29:
 * error: cannot find symbol System.out.println(concatContain("ab", "abcde"));;
 * ^ symbol: method concatContain(String,String) location: class __tester__
 * __tester__.java:33: error: cannot find symbol
 * System.out.println(concatContain("abcd", "cdabcdab")); ^ symbol: method
 * concatContain(String,String) location: class __tester__ __tester__.java:34:
 * error: cannot find symbol System.out.println(concatContain("x", "xx")); ^
 * symbol: method concatContain(String,String) location: class __tester__
 * __tester__.java:35: error: cannot find symbol
 * System.out.println(concatContain("y", "y")); ^ symbol: method
 * concatContain(String,String) location: class __tester__ __tester__.java:36:
 * error: cannot find symbol System.out.println(concatContain("p", "q")); ^
 * symbol: method concatContain(String,String) location: class __tester__
 * __tester__.java:37: error: cannot find symbol
 * System.out.println(concatContain("pq",
 * "qpqpqpqpqpqpqpqpqpqpqpqpqpqpqpqpqq")); ^ symbol: method
 * concatContain(String,String) location: class __tester__ __tester__.java:38:
 * error: cannot find symbol System.out.println(concatContain("pq",
 * "qpqpqpqpqpqpqpqpqpqpqpqpqpqpqpqpq")); ^ symbol: method
 * concatContain(String,String) location: class __tester__ __tester__.java:39:
 * error: cannot find symbol System.out.println(concatContain("pq",
 * "pqpqpqpqpqpqpqpqpqpqpqpqpqpqpqpqq")); ^ symbol: method
 * concatContain(String,String) location: class __tester__ __tester__.java:40:
 * error: cannot find symbol System.out.println(concatContain("pqr", "pq")); ^
 * symbol: method concatContain(String,String) location: class __tester__
 * __tester__.java:41: error: cannot find symbol
 * System.out.println(concatContain("pqr", "pr")); ^ symbol: method
 * concatContain(String,String) location: class __tester__ __tester__.java:42:
 * error: cannot find symbol System.out.println(concatContain("pqr", "qr")); ^
 * symbol: method concatContain(String,String) location: class __tester__
 * __tester__.java:43: error: cannot find symbol
 * System.out.println(concatContain("pqr", "prq")); ^ symbol: method
 * concatContain(String,String) location: class __tester__ __tester__.java:44:
 * error: cannot find symbol System.out.println(concatContain("pqr",
 * "pqrpqrpqr")); ^ symbol: method concatContain(String,String) location: class
 * __tester__ __tester__.java:45: error: cannot find symbol
 * System.out.println(concatContain("pqr", "prr")); ^ symbol: method
 * concatContain(String,String) location: class __tester__ __tester__.java:46:
 * error: cannot find symbol System.out.println(concatContain("pqr",
 * "rpqrpqr")); ^ symbol: method concatContain(String,String) location: class
 * __tester__ __tester__.java:47: error: cannot find symbol
 * System.out.println(concatContain("pqr", "ppqrpqrpqr")); ^ symbol: method
 * concatContain(String,String) location: class __tester__ __tester__.java:48:
 * error: cannot find symbol System.out.println(concatContain("pqr",
 * "rpqrpqrpqrpqrp")); ^ symbol: method concatContain(String,String) location:
 * class __tester__ __tester__.java:49: error: cannot find symbol
 * System.out.println(concatContain("pqr", "pqpqrpqrpqr"));; ^ symbol: method
 * concatContain(String,String) location: class __tester__ 20 errors
 */