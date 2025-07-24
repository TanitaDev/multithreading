class SleepJoinThreadStates extends Thread{
    public static void main(String[] args) throws InterruptedException {
//        Thread th1 = new Thread(new MyRunnable1());
//        SleepJoinThreadStates th2 = new SleepJoinThreadStates();
//
//        th1.start();
//        th2.start();
//
//        th1.join(); //мэйн поток ждет когда поток th1 th2 завершатся а потом продолжит работу
//        th2.join();
//
//        System.out.println("Final");

        System.out.println("method main begins");
        Thread th = new Thread(new Worker());
        System.out.println(th.getState());
        th.start();
        System.out.println(th.getState());
        th.join(); //либо пока все потоки завершат работу либо пока не закончится время
        System.out.println(th.getState());
        System.out.println("method main ends");
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyRunnable1 implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        System.out.println("begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("workEnds");
    }
}