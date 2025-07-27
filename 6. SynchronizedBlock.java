//class SynchronizedBlock {
//    public static void main(String[] args) throws InterruptedException {
//        Thread th = new Thread(new R1());
//        Thread th2 = new Thread(new R1());
//        Thread th3 = new Thread(new R1());
//
//        th.start();
//        th2.start();
//        th3.start();
//        th.join();
//        th2.join();
//        th3.join();
//
//    }
//
//}
//
//class Counter2 {
//    static int count = 0;
//}
//
//class R1 implements Runnable {
//    private void doWork2(){
//        System.out.println("URA");
//    }
//
//    private void doWork() {
//        doWork2();
//        synchronized (this) {
//            Counter2.count++;
//            System.out.println(Counter2.count);
//        }
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 3; i++) {
//            doWork();
//        }
//    }
//}

class Calls {
    static final Object lock = new Object();

    void phoneCall() {
        synchronized (lock) {
            System.out.println("phoneCall call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("phoneCall call ends");
        }
    }

    void skypeCall() {
        synchronized (lock) {
            System.out.println("skypeCall call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("skypeCall call ends");
        }
    }

    void whatsAppCall() {
        synchronized (lock) {
            System.out.println("whatsAppCall call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("whatsAppCall call ends");
        }
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new Rnble1());
        Thread th2 = new Thread(new Rnble2());
        Thread th3 = new Thread(new Rnble3());

        th1.start();
        th2.start();
        th3.start();
    }
}

class Rnble1 implements Runnable {

    @Override
    public void run() {
        new Calls().phoneCall();
    }
}

class Rnble2 implements Runnable {

    @Override
    public void run() {
        new Calls().skypeCall();
    }
}

class Rnble3 implements Runnable {

    @Override
    public void run() {
        new Calls().whatsAppCall();
    }
}
