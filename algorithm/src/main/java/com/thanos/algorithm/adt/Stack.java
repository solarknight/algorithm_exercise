package com.thanos.algorithm.adt;

import java.util.EmptyStackException;

/**
 * Created by solarknight on 2017/4/3.
 */
public interface Stack<E> extends Collection<E> {

  void push(E e);

  E pop();

  E peek();

  class FixedCapacityStack<E> implements Stack<E> {
    private E[] array;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int cap) {
      if (cap < 1) {
        throw new IllegalArgumentException();
      }
      this.array = (E[]) new Object[cap];
    }

    public int size() {
      return size;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public boolean contains(E var1) {
      for (int i = 0; i < size; i++) {
        if (array[i].equals(var1)) {
          return true;
        }
      }
      return false;
    }

    public boolean add(E var1) {
      push(var1);
      return true;
    }

    public boolean remove(E var1) {
      throw new UnsupportedOperationException();
    }

    public void push(E e) {
      if (size > array.length - 1) {
        throw new IllegalStateException();
      }
      array[size++] = e;

    }

    public E pop() {
      return array[--size];
    }

    public E peek() {
      if (size == 0) {
        throw new EmptyStackException();
      }
      return array[size - 1];
    }
  }

}
