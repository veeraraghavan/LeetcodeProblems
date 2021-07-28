/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   10/25/20, 9:56 PM
 * =========================================
 */
// https://leetcode.com/problems/ipo/
package com.practice.leetcode.array;

import java.util.PriorityQueue;

public class IPO {
  public static void main(String[] args) {
    IPO me = new IPO();
    System.out.println(me.findMaximizedCapital(2, 0, new int[] {1, 2, 3}, new int[] {1, 1, 1}));
  }

  private int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    /* PriorityQueue<Integer> capital = new PriorityQueue<>((a, b) -> Capital[a] - Capital[b]);
    PriorityQueue<Integer> profit = new PriorityQueue<>((a, b) -> Profits[b] - Profits[a]);
    int res = 0;
    for (int i = 0; i < Profits.length; i++) {
      capital.offer(i);
      // profit.offer(i);
    }
    int no_projects = k;
    int profits = 0;
    int remCapa = W;
    while (k > 0 && Capital[capital.peek()] <= remCapa) {
      if (!capital.isEmpty() && Capital[capital.peek()] <= remCapa) {
        while (!capital.isEmpty() && Capital[capital.peek()] <= remCapa) {
          profit.offer(capital.poll());
        }
        while (k > 0 && !profit.isEmpty()) {
          profits += Profits[profit.peek()];
          remCapa += Profits[profit.poll()];
          k--;
        }
      }
      if (capital.isEmpty()) return remCapa;
      // profit.

    }
    return remCapa;*/
    int n = Profits.length;
    PriorityQueue<Integer> minCapitalHeap =
        new PriorityQueue<>(n, (i1, i2) -> Capital[i1] - Capital[i2]);
    PriorityQueue<Integer> maxProfitHeap =
        new PriorityQueue<>(n, (i1, i2) -> Profits[i2] - Profits[i1]);

    // insert all project capitals to a min-heap
    for (int i = 0; i < n; i++) minCapitalHeap.offer(i);

    // let's try to find a total of 'numberOfProjects' best projects
    int availableCapital = W;
    for (int i = 0; i < k; i++) {
      // find all projects that can be selected within the available capital and insert them in a
      // max-heap
      while (!minCapitalHeap.isEmpty() && Capital[minCapitalHeap.peek()] <= availableCapital)
        maxProfitHeap.add(minCapitalHeap.poll());

      // terminate if we are not able to find any project that can be completed within the available
      // capital
      if (maxProfitHeap.isEmpty()) break;

      // select the project with the maximum profit
      availableCapital += Profits[maxProfitHeap.poll()];
    }

    return availableCapital;
  }
}
