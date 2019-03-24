package Inherited;

import annotation.Age;
import annotation.MyTestAnnotation;

@MyTestAnnotation(name = "father",age = 50)
public class Father {

    @Age(35)
    private int age;

}
