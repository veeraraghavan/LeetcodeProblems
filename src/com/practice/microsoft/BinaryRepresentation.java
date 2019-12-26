package com.practice.microsoft;

public class BinaryRepresentation {
    public static void main(String[] args) {
        BinaryRepresentation me = new BinaryRepresentation();
        System.out.println(me.binaryRepresentation(0));
    }

    public int binaryRepresentation(int number) {
        if (number == 0)
            return 0;
        int temp = number;
        String res = "";
        while (number > 0) {
            res = (number % 2 == 0 ? "0" : "1") + res;
            number = number / 2;
        }
        return Integer.parseInt(res);
    }
}
