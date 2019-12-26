package com.practice.scribble;

public class References {


    public static void main(String[] args) {
        References current = new References();
        Reference me = new Reference(1);
        current.set(me);
        System.out.println(me.value);
    }

    public void set(Reference ref) {
        ref = new Reference(3);
    }

}
