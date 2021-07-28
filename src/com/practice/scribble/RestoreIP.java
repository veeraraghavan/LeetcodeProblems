package com.practice.scribble;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    public static void main(String[] args) {
        RestoreIP me = new RestoreIP();
        me.restoreIpAddresses("25525511135");
        System.out.println("");

    }
    public List<String> restoreIpAddresses(String s) {
        // Basic Boundary conditions
        // Less than 4 , greater than 12 reject
        // Leading 0 /greater than 2 - reject
        // Use dfs starting choose one character at a time
        // When going to next level, remaining level should be less than
        // Second triple <= 9, third triple <=6 and third triple <=3 - done
        List<String> result = new ArrayList<>();
        getIPAddresses(s,0,result,"",-1);
        return result;

    }

    public void getIPAddresses(String s, int index, List<String> result,String temp,int traversed){
        if(index==4)
        {
            result.add(temp);
            return;
        }

        int tempNum = -1;
        for(int i=traversed+1;i<traversed+4;i++ ){
            if(tempNum==-1){
                // Since no triplet can start with 3
                int first = s.charAt(i)-'0';
                if( first == 0 || ( first > 2 && s.length()-traversed-1 <=2))
                    return;
                if(!validIndexPerLength(s.length()-i,index+1)){
                    tempNum = first;
                    continue;
                }
                tempNum = first;
                getIPAddresses(s,index+1,result,temp+"."+first,i);


            }else{
                int next = s.charAt(i)-'0';
                if(next > 5 )
                    return;
                if(!validIndexPerLength(s.length()-i-1,index+1)){
                    tempNum = tempNum*10+next;
                    continue;
                }
                tempNum = tempNum*10+next;
                getIPAddresses(s,index+1,result,temp+"."+tempNum,i);
            }
        }
    }

    public boolean validIndexPerLength(int remaining,int index){
        boolean result = false;
        switch(index){
            case 1:
                if(remaining <= 9) result = true;
                break;
            case 2:
                if(remaining <= 6) result = true;
                break;
            case 3:
                if(remaining <= 3) result = true;
                break;
            case 4:
                if(remaining <= 0) result = true;
                break;
        }
        return result;


    }
}
