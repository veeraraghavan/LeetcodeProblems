package com.practice.amzn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonTest2 {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(20);
        input.add(4);
        input.add(8);
        input.add(2);
        AmazonTest2 me = new AmazonTest2();
        System.out.println(me.minimumTime(2,input));
    }
    int minimumTime(int numOfParts, List<Integer> parts)
    {
        if(parts.size()==0)
            return 0;
        int minimumTime=0;
        int[] partsArray = new int[parts.size()];

        for(int i=0;i<partsArray.length;i++)
            partsArray[i]=parts.get(i);
        Arrays.sort(partsArray);//sort the Arrays

        int[] resultTemp = new int[parts.size()+1];
        resultTemp[0]=partsArray[0];
        for(int i=1;i<parts.size();i++){
            resultTemp[i]=resultTemp[i-1]+partsArray[i];
        }
        for(int i=1;i<numOfParts;i++){
            minimumTime+=resultTemp[i];
        }
        return minimumTime;
    }
}
