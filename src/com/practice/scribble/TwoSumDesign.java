package com.practice.scribble;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSumDesign {
    public static void main(String[] args) {
        TwoSumDesign me = new TwoSumDesign();
        me.add(1);
        me.add(1);
        System.out.println(me.find(0));
        System.out.println(me.find(1));
        System.out.println(me.find(2));
        me.add(-1);
        System.out.println(me.find(0));
        System.out.println(me.find(1));
        System.out.println(me.find(-2));
        me.add(-1);
        System.out.println(me.find(-2));

    }
    HashMap<Integer,Integer> map = new HashMap();
    ArrayList<Integer> nums = new ArrayList();

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
        map.put(number,nums.size()-1);

    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int index = 0;
        for(int num : nums){
            if(map.containsKey(value-num) && map.get(value-num)!= index){
                return true;
            }
            index++;
        }
        return false;

    }
}
