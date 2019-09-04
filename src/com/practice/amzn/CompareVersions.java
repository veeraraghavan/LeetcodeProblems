package com.practice.amzn;

public class CompareVersions {
    public static void main(String[] args) {
        CompareVersions me = new CompareVersions();
        System.out.println(me.compareVersion("1.0","1.1"));
    }
    public int compareVersion(String version1, String version2) {
        if(version1.length()<version2.length()){
            int res = compareVersion(version2,version1);
            if(res==0) return res;
            return res * -1;

        }

        String[] left = version1.split("\\.");
        String[] right=version2.split("\\.");
        int i=0;
        String leftElement="",rightElement="";
        while(i<left.length){
            leftElement = left[i];
            if(i<right.length)
                rightElement = right[i];
            else
                rightElement = "0";
            int leftInt = Integer.parseInt(leftElement);
            int rightInt = Integer.parseInt(rightElement);
            if(leftInt<rightInt)
                return -1;
            else if(leftInt>rightInt)
                return 1;
            i++;


        }
        return 0;
//        int leftstart=0,leftend=0,rightstart=0,rightend=0, leftCount=0,rightCount=0;
//        while(leftstart<version1.length()){
//            while(leftend<version1.length()&&version1.charAt(leftend)!='.')leftend++;
//            leftCount=Integer.parseInt(version1.substring(leftstart,leftstart+leftend));
//            leftend++;leftstart=leftend;leftend=0;
//            while(rightend<version2.length()&&version2.charAt(rightend)!='.')rightend++;
//            if(rightCount!=-99){
//                rightCount=Integer.parseInt(version2.substring(rightstart,rightstart+rightend));
//                rightend++;rightstart=rightend;rightend=0;
//            }
//            if(leftCount>rightCount)return 1;
//            else if(leftCount<rightCount) return -1;
//            leftCount = -99;
//            rightCount = -99;
//        }
//        return 0;
    }
}
