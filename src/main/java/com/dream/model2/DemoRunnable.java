package com.dream.model2;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

public class DemoRunnable {
    public static void startThread(Runnable run) {
        new Thread(run).start();
    }

    public static void main(String[] args) {
//        startThread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("-------"+Thread.currentThread().getName());
//            }
//        });

        startThread(()->
            System.out.println("-------"+Thread.currentThread().getName())
        );
    }
}
