package com.practice.playground.Arithmetic;

import java.util.HashMap;

public class IntegerToString {
    HashMap<Integer, String> map = new HashMap<>();
    public void initialize() {
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
        map.put(100, "Hundred");
        map.put(1000, "Thousand");
        map.put(1000000, "Million");
        map.put(1000000000, "Billion");
        map.put(0, "Zero");
    }

    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        int local = num;
        String result = "";
        int rem = 0;
        initialize();
        while (local > 0) {
            if (local >= 1000000000) {
                int temp = local;
                temp = local/1000000000;
                if(temp>9){
                    result+=numberToWords(temp)+ " "+getTextforNum(1000000000);
                }else{
                    result+=getTextforNum(temp)+ " "+getTextforNum(1000000000);
                }
                local = local%1000000000;
            } else if (local >= 1000000) {
                int temp = local;
                temp = local/1000000;
                if(temp>9){
                    result+=result.equals("")?numberToWords(temp)+ " "+getTextforNum(1000000):" "+numberToWords(temp)+ " "+getTextforNum(1000000);
                }else{
                    result+=result.equals("")?getTextforNum(temp)+ " "+getTextforNum(1000000):" "+getTextforNum(temp)+ " "+getTextforNum(1000000);
                }
                local = local%1000000;
            } else if (local >= 1000) {
                int temp = local;
                temp = local/1000;
                if(temp>20){
                    result+=result.equals("")?numberToWords(temp)+ " "+getTextforNum(1000):" "+numberToWords(temp)+ " "+getTextforNum(1000);
                }else{
                    result+=result.equals("")?getTextforNum(temp)+ " "+getTextforNum(1000):" "+getTextforNum(temp)+ " "+getTextforNum(1000);
                }
                local = local%1000;
            } else if (local >= 100) {
                int temp = local;
                temp = local / 100;
                result += result.equals("")?getTextforNum(temp) + " "+getTextforNum(100):" "+getTextforNum(temp) + " "+getTextforNum(100);
                local = local % 100;
            } else if (local >= 90) {
                int temp = local;
                temp = local / 90;
                result+=result.equals("")?getTextforNum(90):" "+getTextforNum(90);
                local = local % 90;
            } else if (local >= 80) {
                int temp = local;
                temp = local / 80;
                result+=result.equals("")?getTextforNum(80):" "+getTextforNum(80);
                local = local % 80;

            }else if (local >= 70) {
                int temp = local;
                temp = local / 70;
                result+=result.equals("")?getTextforNum(70):" "+getTextforNum(70);
                local = local % 70;
            }
            else if (local >= 60) {
                int temp = local;
                temp = local / 60;
                result+=result.equals("")?getTextforNum(60):" "+getTextforNum(60);
                local = local % 60;
            }else if (local >= 50) {
                int temp = local;
                temp = local / 50;
                result+=result.equals("")?getTextforNum(50):" "+getTextforNum(50);
                local = local % 50;
            }
            else if (local >= 40) {
                int temp = local;
                temp = local / 40;
                result+=result.equals("")?getTextforNum(40):" "+getTextforNum(40);
                local = local % 40;
            }else if (local >= 30) {
                int temp = local;
                temp = local / 30;
                local = local % 30;
                result +=  result.equals("")?getTextforNum(30):" "+getTextforNum(30);
            }
            else if (local >= 20) {
                int temp = local;
                temp = local / 20;
                result += result.equals("")? getTextforNum(20):" "+getTextforNum(20);
                local = local % 20;

            }else if (local >= 10) {
                // int temp = local;
                // temp = local / 10;
                result += result.equals("")?getTextforNum(local):" "+getTextforNum(local);
                local = 0;
            }
            else {
                result += result.equals("")?getTextforNum(local):" " + getTextforNum(local);
                local = 0;
            }
        }
        return result;
    }

    public String getTextforNum(int n) {
        return map.get(n);
    }

    public static void main(String[] args) {
        IntegerToString me = new IntegerToString();
        System.out.println(me.numberToWords(0));
    }
}
