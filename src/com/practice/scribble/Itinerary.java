package com.practice.scribble;

import java.util.*;

public class Itinerary {
    public static void main(String [] args){
        Itinerary me = new Itinerary();

        System.out.println(me.findItinerary(List.of(List.of("MUC","LHR"),List.of("JFK","MUC"),List.of("SFO","SJC"),List.of("LHR","SFO"))));

    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, SortedSet<String>> adjList = new HashMap();

        for(List<String> itinerary:tickets){
            if(adjList.containsKey(itinerary.get(0))){
                adjList.get(itinerary.get(0)).add(itinerary.get(1));
            }else{
                SortedSet<String> tempSet = new TreeSet<>();
                tempSet.add(itinerary.get(1));
                adjList.put(itinerary.get(0),tempSet);
            }
        }
        List<String> result = new ArrayList();
        result.add("JFK");
        String current = "JFK",next="";
        while(adjList.size()>0){
            next = adjList.get(current).first();
            adjList.get(current).remove(next);
            if(adjList.get(current).size()==0){
                adjList.remove(current);
            }
            result.add(next);
            current=next;
        }
        return result;

    }
}
