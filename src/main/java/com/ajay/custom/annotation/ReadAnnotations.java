package com.ajay.custom.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by ajayk297 on 21/10/17.
 */
public class ReadAnnotations {

    public static void main(String[] args) {
        System.out.println("Parsing annotations.............");

        Class obj = ApplyAnnotation.class;

        if (obj.isAnnotationPresent(AnnotationExample.class)){
            System.out.println("Annotation present");
        }else{
            System.out.println("Annotation not present at class level");
        }

        for(Method method: obj.getDeclaredMethods()){
            if(method.isAnnotationPresent(AnnotationExample.class)){
                Annotation annotation = method.getAnnotation(AnnotationExample.class);
                AnnotationExample annotationExample = (AnnotationExample) annotation;
                System.out.print("annotation value-"+annotationExample.value()+", ");
                if (annotationExample.enabled()){
                    try {
                        method.invoke(obj.newInstance());
                    } catch (Exception e) {
                        System.out.println("Test failed for method-"+method.getName()+e.getCause());
                    }
                }else{
                    System.out.println("Annotation present but not enabled on- " + method.getName());
                }
            }else{

                System.out.println("Annotation not present at method level on- "+ method.getName());
            }
        }
    }
}
