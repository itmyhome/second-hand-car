package com.secondhandcar.platform.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiet on 2017/10/23.
 */
public class TestClass {

    private ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap();

    public synchronized void add(String key) {

        Integer value = concurrentHashMap.get(key);
        if (value == null) {
            System.out.println("value is null");
            concurrentHashMap.put(key, 1);
        } else {
            System.out.println("value is not null");
            concurrentHashMap.put(key, value + 1);
        }
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        final CountDownLatch begin = new CountDownLatch(1); //为0时开始执行
        final ExecutorService exec = Executors.newFixedThreadPool(9);

        for (int i = 0; i < 9; i++) {
            Runnable runnable = ()-> {

                    try {
                        begin.await(); //等待直到 CountDownLatch减到1
                        testClass.add("1");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            };
            exec.submit(runnable);
        }
        System.out.println("开始执行");
        begin.countDown(); // begin减一，开始并发执行
        exec.shutdown();

    }
}
