package com.finedroid.multiWork;

public class MultiService {

    //等同于synchronized(this)
    public synchronized void testMethod() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }
    }

    //等同于synchronized(MultiService.class)
    public synchronized static void testStaticMethod() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }
    }


    public void testClass() {
        synchronized (MultiService.class) {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + ":" + count);
            }
        }

    }


    public void testThis() {
        synchronized (this) {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + ":" + count);
            }
        }
    }


    public void testObject(Object object) {
        synchronized (object) {
            int count = 0;
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + ":" + count);
            }
        }
    }

    public static class MyThread extends Thread {

        private MultiService multiService;

        public MyThread(MultiService multiService) {
            this.multiService = multiService;
        }

        @Override
        public void run() {
//            multiService.testObject(multiService);

//            multiService.testClass();
//            multiService.testStaticMethod();

            multiService.testMethod();
//            multiService.testThis();
        }
    }
}
