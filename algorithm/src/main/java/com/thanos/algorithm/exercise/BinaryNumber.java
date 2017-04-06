package com.thanos.algorithm.exercise;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Write a code fragment that puts the binary representation of a positive integer N
 * into a String s.<br/>
 * BTW: Java has a built-in method {@link Integer#toBinaryString(int)} for this job.<br/>
 * <p>
 * Created by solarknight on 2017/4/3.
 */
public class BinaryNumber {

  public static String toBinaryString1(int input) {
    String s = "";
    for (int n = input; n > 0; n = n >> 1) {
      s = (n % 2) + s;
    }
    return s;
  }

  public static String toBinaryString2(int input) {
    StringBuilder sb = new StringBuilder(32);
    for (int n = input; n > 0; n = n >> 1) {
      sb.append(n % 2);
    }
    return sb.reverse().toString();
  }

  public static String toBinaryString3(int input) {
    StringBuilder sb = new StringBuilder(32);
    while (input != 0) {
      if ((input & 1) != 0) {
        sb.append("1");
      } else {
        sb.append("0");
      }

      input = input >> 1;
    }
    return sb.reverse().toString();
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @Fork(1)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  @Warmup(iterations = 5)
  @Measurement(iterations = 5)
  public void measureMethod1() {
    int count = 1 << 20;
    for (int i = 0; i < count; i++) {
      toBinaryString1(1232437439);
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @Fork(1)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  @Warmup(iterations = 5)
  @Measurement(iterations = 5)
  public void measureMethod2() {
    int count = 1 << 20;
    for (int i = 0; i < count; i++) {
      toBinaryString2(1232437439);
    }
  }

  @Benchmark
  @BenchmarkMode(Mode.AverageTime)
  @Fork(1)
  @OutputTimeUnit(TimeUnit.MILLISECONDS)
  @Warmup(iterations = 5)
  @Measurement(iterations = 5)
  public void measureMethod3() {
    int count = 1 << 20;
    for (int i = 0; i < count; i++) {
      toBinaryString3(1232437439);
    }
  }
}
