package com.practice.playground.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
    	
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		int res = 0;
		Set<String> set = new HashSet<>(wordList);

		if (!set.contains(endWord)) {
			return 0;
		}
		Queue<String> queue = new LinkedList<>();

		queue.offer(beginWord);

		while (!queue.isEmpty()) {

			String word = queue.poll();

				if (word.equals(endWord)) {
					return res;
				}

				for (int k = 0; k < word.length(); k++) {
					char[] cArr = word.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {

						cArr[k] = ch;

						String s = new String(cArr);

						if (s.equals(endWord)) {
							return res+1;
						}
						
						if (set.contains(s) && !s.equals(word)) {
							queue.offer(s);
							set.remove(s);
						}
					}
				}

			res++;

		}

		return 0;

	}

    public int recursiveLadder(String beginWord, String endWord, List<String> wordList, int count, int index) {
        return 0;
    }
}
