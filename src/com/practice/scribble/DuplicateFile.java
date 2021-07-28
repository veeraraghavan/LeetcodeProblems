package com.practice.scribble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateFile {
    public static void main(String[] args) {
        DuplicateFile me = new DuplicateFile();
        //TODO Look for the deeper questions . Large file comparison tricks

    }

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap();
        for (String path : paths) {
            String[] split = path.split(" ");
            for (int i = 1; i < split.length; i++) {
                int index = split[i].indexOf("(");
                String content = split[i].substring(index + 1, split[i].length() - 1);
                map.putIfAbsent(content, new ArrayList());
                List<String> temp = map.get(content);
                temp.add(split[0] + "/" + split[i].substring(0, index));
                map.put(content, temp);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1)
                result.add(entry.getValue());
        }
        return result;
    }
}
