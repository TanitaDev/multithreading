class ThreadNameThreadPriority {
    public static void main(String[] args) {
        MyThread5 thread5 = new MyThread5();
        thread5.setPriority(Thread.MAX_PRIORITY);
        System.out.println(thread5.getName() + " " + thread5.getPriority());

        MyThread5 thread6 = new MyThread5();
        System.out.println(thread6.getName() + " " + thread6.getPriority());

        System.out.println("Current thread " + Thread.currentThread().getName());
        Thread th6 = new Thread(new MyThread6());
        th6.run(); // так делать не надо
    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {
        System.out.println("privet");
    }
}

class MyThread6 implements Runnable {
    @Override
    public void run() {
        System.out.println("Поток запущенный с run " + Thread.currentThread().getName());
    }
}
