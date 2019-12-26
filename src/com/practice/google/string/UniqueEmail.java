package com.practice.google.string;

import java.util.HashMap;

public class UniqueEmail {
    public static void main(String[] args) {
        UniqueEmail me = new UniqueEmail();
        System.out.println(me.numUniqueEmails(new String[]{"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"}));
    //["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
        System.out.println(me.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));

    }

    public int numUniqueEmails(String[] emails) {
        HashMap<String, Integer> uniqueEmails = new HashMap<>();
        for (String email : emails) {
            String tempMail = getProcessedEmail(email);
            uniqueEmails.put(tempMail, uniqueEmails.getOrDefault(tempMail, 0) + 1);
        }
        return uniqueEmails.size();

    }

    public String getProcessedEmail(String email) {
        String[] emailWithDomain = email.split("@");
        String result = emailWithDomain[0].replaceAll("\\.", "");
        if(result.indexOf("+")!=-1){
            result=result.substring(0,result.indexOf("+"));
        }
        //result = result.replaceAll("\\+", "");
        return result + "@" + emailWithDomain[1];
    }
}
