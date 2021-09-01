/*
 * ==========================================
 *  Author: Veeraraghavan Narasimhan
 *  Date:   8/31/21, 5:44 PM
 * =========================================
 */

package com.practice.serious;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
  public static void main(String[] args) {
    EmployeeFreeTime me = new EmployeeFreeTime();
    List<List<Interval>> input = new ArrayList<>();
    List<Interval> a = new ArrayList<>();
    a.add(new Interval(1, 3));
    a.add(new Interval(6, 7));
    input.add(a);
    a = new ArrayList<>();
    a.add(new Interval(2, 4));
    input.add(a);
    a = new ArrayList<>();
    a.add(new Interval(2, 5));
    a.add(new Interval(9, 12));
    input.add(a);
    me.employeeFreeTime(input);
  }

  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    PriorityQueue<EmployeeInterval> pq =
        new PriorityQueue<>((a, b) -> a.interval.start - b.interval.start);
    List<Interval> result = new ArrayList<>();
    for (int i = 0; i < schedule.size(); i++) {
      pq.offer(new EmployeeInterval(0, i, schedule.get(i).get(0)));
    }
    Interval previous = pq.peek().interval;
    while (!pq.isEmpty()) {
      EmployeeInterval interval = pq.poll();
      if (previous.end < interval.interval.start) {
        result.add(new Interval(previous.end, interval.interval.start));
        previous = interval.interval;
      } else {
        if (previous.end < interval.interval.end) {
          previous = interval.interval;
        }
      }
      List<Interval> empSchedule = schedule.get(interval.employee);
      if (empSchedule.size() > interval.index + 1) {
        Interval temp = empSchedule.get(interval.index + 1);
        pq.offer(new EmployeeInterval(interval.index + 1, interval.employee, temp));
      }
    }

    return result;
  }
}

class EmployeeInterval {
  public int index;
  public int employee;
  public Interval interval;

  public EmployeeInterval(int index, int employee, Interval interval) {
    this.index = index;
    this.employee = employee;
    this.interval = interval;
  }
}

class Interval {
  public int start;
  public int end;

  public Interval() {}

  public Interval(int _start, int _end) {
    start = _start;
    end = _end;
  }
}
