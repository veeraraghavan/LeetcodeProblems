package com.practice.leetcode.string;

import com.practice.leetcode.array.EqualizeArray;

import javax.swing.plaf.synth.SynthEditorPaneUI;

public class Equation {
    public static void main(String[] args) {

        Equation me = new Equation();
        String equation = "x+5-3+x=6+x-2";
        System.out.println(me.solveEquation(equation));

    }

    public String solveEquation(String equation) {

        String[] eq = equation.split("=");

        String sign = "+";
        int number = 0;
        int X1 = 0;
        int i= 0;
        while (i < eq[0].length()){

            if (eq[0].charAt(i) != '+' ){

                if (eq[0].charAt(i) == 'x'){
                    //if x
                    if (number == 0){
                        X1 = 1;
                    }else X1 = X1 + number;
                }

                if (Character.isDigit(eq[0].charAt(i))){
                    //if its a number
                    number = (number * 10) + eq[0].charAt(i) - '0';
                }

            }


        }

        return  null;
    }

}
