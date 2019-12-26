package com.practice.amzn;

import java.util.ArrayList;
import java.util.List;

public class ReorderLogFiles {
    public static void main(String[] args) {
        ReorderLogFiles me = new ReorderLogFiles();
        String[] result = me.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"});
        System.out.println("Came here");
    }

    public String[] reorderLogFiles(String[] logs) {
        String[] finalResult = new String[logs.length];
        ArrayList<String> alphaWords = new ArrayList<String>();
        ArrayList<String> numberWords = new ArrayList<String>();
        for (String log : logs) {
            String[] tokenizedString = log.split(" ");
            if (Character.isDigit(tokenizedString[1].charAt(0))) {
                numberWords.add(log);
            } else {
                alphaWords.add(log);
            }
        }

        // String[] result = new String[numberWords.size()];
        // for(int i=0;i<numberWords.size();i++){
        //     result[i] = numberWords.get(i);
        // }
        String[] sortedWords = new String[alphaWords.size()];
        sortAlphaWords(alphaWords, sortedWords);
        for (int i = 0; i < sortedWords.length; i++) {
            finalResult[i] = sortedWords[i];
        }
        for (int i = alphaWords.size(); i < finalResult.length; i++) {
            finalResult[i] = numberWords.get(i - alphaWords.size());
        }
        //result = numberWords.toArray();
        return finalResult;

    }

    public void sortAlphaWords(List<String> words, String[] sorted) {
        for (int i = 0; i < words.size(); i++) {
            sorted[i] = words.get(i);
        }

        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = i + 1; j < sorted.length; j++) {
                if (!lowerString(sorted[i], sorted[j])) {
                    String tempString = sorted[j];
                    sorted[j] = sorted[i];
                    sorted[i] = tempString;
                }

            }
        }

    }

    public boolean lowerString(String a, String b) {

        String[] aWords = a.split(" ");
        String[] bWords = b.split(" ");
        if (aWords.length > bWords.length)
            return !(lowerString(b, a));
        for (int i = 1; i < aWords.length; i++) {
            if (aWords[i].compareTo(bWords[i]) > 0)
                return false;
            else if(aWords[i].compareTo(bWords[i])<0)
                return true;
        }
        return true;

    }
}
