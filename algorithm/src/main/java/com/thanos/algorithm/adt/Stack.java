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
      E item = array[--size];
      array[size] = null;
      return item;
    }

    public E peek() {
      if (size == 0) {
        throw new EmptyStackException();
      }
      return array[size - 1];
    }
  }

  class DynamicResizeStack<E> implements Stack<E> {
    private static final int DEFAULT_SIZE = 10;

    private E[] array;
    private int size = 0;

    public DynamicResizeStack() {
      this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public DynamicResizeStack(int cap) {
      if (cap < 1) {
        throw new IllegalArgumentException();
      }
      this.array = (E[]) new Object[cap];
    }

    @Override
    public int size() {
      return size;
    }

    @Override
    public boolean isEmpty() {
      return size == 0;
    }

    @Override
    public boolean contains(E var1) {
      for (int i = 0; i < size; i++) {
        if (array[i].equals(var1)) {
          return true;
        }
      }
      return false;
    }

    @Override
    public boolean add(E var1) {
      push(var1);
      return true;
    }

    @Override
    public boolean remove(E var1) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void push(E e) {
      if (size == array.length) {
        ensureCapacity();
      }
      array[size++] = e;
    }

    @SuppressWarnings("unchecked")
    private void ensureCapacity() {
      E[] tmp = (E[]) new Object[array.length * 2 + 1];
      System.arraycopy(array, 0, tmp, 0, array.length);
      array = tmp;
    }

    @Override
    public E pop() {
      E item = array[--size];
      array[size] = null;
      return item;
    }

    @Override
    public E peek() {
      if (size == 0) {
        throw new EmptyStackException();
      }
      return array[size - 1];
    }
  }

}
