package com.ajay.innerclass;

/**
 * Created by ajayk297 on 03/12/17.
 */
public class OuterClass {

    private int id;
    private String name;

    public OuterClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display(){
        System.out.println(id + " " + name);
    }

    //static inner class has existence without outer class too, and can be used
    static class StaticInnerClass{
        private int innerId;

        public StaticInnerClass(int innerId) {
            this.innerId = innerId;
        }

        public void display() {
            System.out.println("Inside static inner class");
            //cannot use outer class member variables as they are not static
            //System.out.println(id);
            System.out.println(innerId);
        }
    }

    public static void main(String[] args) {

        OuterClass outer = new OuterClass(2, "ajay");
        outer.display();

        //can directly create instance of static inner class without any outer class reference
        StaticInnerClass inner = new StaticInnerClass(4);
        inner.display();
    }
}
