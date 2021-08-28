小知识:

1. 遍历 map: i, v := range m
2. 取值 map: i, ok := m["route"]

```java
import XJLTU.Major.*;
import Yourself.Heart

// this advise for student who hesitates with EE and Computer
public static Major chooseYourMajor(XJTLUer you) {
    
    Major answer = null; 
	
    if (you.love(Promgarmming) || you.hate(Major.Math)) {
        answer = Major.ICS;
        you.need(studyByYourSelf);
    }
  
    if (you.love(Major.Math) && you.love(Promgarmming)) {
        
        if (you.love(CS)>you.love(EE)) {
            answer = Major.DMT;
            you.willLearn( 0.5 * Major.ICS + 0.5 * Major.EEE );
        } else {
            answer = Major.CST;
            you.willLearn( 0.3 * Major.ICS + 0.7 * Major.EEE );
        }
    } else {
        answer = Major.EEE;
    }
    
    if (you.alreadyHasDicision()){
        answer = yourslef.followYourHeart();
    }
    return answer;
}
```

