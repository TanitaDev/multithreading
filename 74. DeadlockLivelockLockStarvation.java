class DeadlockLivelockLockStarvation {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();


    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }
}


class Thread10 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread10: Попытка захватить монтор объекта lock1");
        synchronized (DeadlockLivelockLockStarvation.lock1) {
            System.out.println("Thread10: Монитор объекта lock1 захвачен");
            System.out.println("Thread10: Попытка захватить монтор объекта lock2");
            synchronized (DeadlockLivelockLockStarvation.lock2) {
                System.out.println("Thread10: Мониторы объектов lock1 lock2 захвачены");
            }
        }
    }
}

class Thread20 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread20: Попытка захватить монтор объекта lock2");
        synchronized (DeadlockLivelockLockStarvation.lock2) {
            System.out.println("Thread20: Монитор объекта lock2 захвачен");
            System.out.println("Thread20: Попытка захватить монтор объекта lock2");
            synchronized (DeadlockLivelockLockStarvation.lock1) {
                System.out.println("Thread20: Мониторы объектов lock1 lock2 захвачены");
            }
        }
    }
}

//Livelock - 2 или более потоков залочены на время или навсегда ожидают друг друга делают какую то работу но без результата
//Lock Starvation - ожидание когда менее приоритетные потоки ждут долго или всегда чтобы запуститься