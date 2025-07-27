class SynchronizedMethod {
    static int count = 0;

    public static synchronized void incremet() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread th = new Thread(new MyThread());
//        Thread th2 = new Thread(new MyThread());
//        Thread th3 = new Thread(new MyThread());
//
//        th.start();
//        th2.start();
//        th3.start();

        Thread th = new Thread(new R());
        Thread th2 = new Thread(new R());

        th.start();
        th2.start();
        th.join();
        th2.join();

        System.out.println(count);
    }

}

class Counter {
    static int count = 0;
}

class MyThread implements Runnable {
    public void increment() {
        Counter.count++;
        System.out.println(Counter.count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}

class R implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            SynchronizedMethod.incremet();
        }
    }
}
