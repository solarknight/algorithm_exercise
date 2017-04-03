package com.thanos.algorithm.adt;

/**
 * Created by solarknight on 2017/4/3.
 */
public interface Collection<E> {

  int size();

  boolean isEmpty();

  boolean contains(E var1);

  boolean add(E var1);

  boolean remove(E var1);
}
