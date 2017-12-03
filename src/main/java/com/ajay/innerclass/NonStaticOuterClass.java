package com.ajay.innerclass;

/**
 * Created by ajayk297 on 03/12/17.
 */
public class NonStaticOuterClass {

    private int id;
    private String name;

    public NonStaticOuterClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void display(){
        System.out.println(id + " " + name);
    }

    //a non-static inner class
    class NonStaticInnerClass{
        private int innerId;

        public NonStaticInnerClass(int innerId) {
            this.innerId = innerId;
        }

        public void display() {
            //we can access member variables of outer class
            System.out.println(id);
            System.out.println(innerId);
        }
    }

    public static void main(String[] args) {

        NonStaticOuterClass outer = new NonStaticOuterClass(2, "ajay");
        outer.display();

        //cannot create instance of inner class directly without referring outer class
        NonStaticInnerClass inner = outer.new NonStaticInnerClass(4);
        inner.display();

    }
}
