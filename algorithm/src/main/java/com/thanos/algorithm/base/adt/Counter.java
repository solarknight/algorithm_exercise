package com.thanos.algorithm.base.adt;

/**
 * @author peiheng.zph created on 17/3/19 下午11:53
 * @version 1.0
 */
public final class Counter {
  private final String name;
  private int count;

  public Counter(String name) {
    this.name = name;
  }

  public void increment() {
    count++;
  }

  public int tally() {
    return count;
  }

  @Override
  public String toString() {
    return name + ": " + count;
  }

  public static void main(String[] args) {
    Counter head = new Counter("head");
    Counter tail = new Counter("tail");

    head.increment();
    head.increment();
    tail.increment();

    System.out.println(head + " " + tail);
    System.out.println(head.tally() + tail.tally());
  }
}
