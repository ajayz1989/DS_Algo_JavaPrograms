package com.ajay.custom.annotation;

/**
 * Created by ajayk297 on 21/10/17.
 */
public class ApplyAnnotation {

    @AnnotationExample(value = 1)
    public void method1(){
        System.out.println("Hey it ran");
    }

    @AnnotationExample(enabled = false)
    public void method2(){
        if (true){
            throw new RuntimeException("Will not be called as it is false");
        }
    }

    @AnnotationExample(value = 2)
    public void method3(){
        if (true){
            throw new RuntimeException("Failed test");
        }

    }
}
