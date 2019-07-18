package com.dev.devinspringboot.Threads;

/*
    两个线程同时访问静态修饰的同步方法以及非静态同步方法
 */
public class ThreadDemo1 implements Runnable {

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
           method1();
        } else {
           method2();
        }
    }


    public synchronized static void method1() {
        System.out.println("我是静态修饰的加锁方法method1: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("静态修饰的加锁方法结束");
    }

    public synchronized void method2() {
        System.out.println("我是非静态修饰的加锁方法method2: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("非静态修饰的加锁方法结束");
    }

    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        new Thread(threadDemo1).start();
        new Thread(threadDemo1).start();
    }
}
