class Creation {
    public static void main(String[] args) {

        //Вариант создания - 1
        MyThread1 th1 = new MyThread1();
        MyThread2 th2 = new MyThread2();

        //Вариант создания - 2
        Thread th3 = new Thread(new MyThread3());

        //Вариант создания - 3
        Thread th4 = new Thread(() -> System.out.println("hello"));

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 200; i > 101; i--) {
            System.out.println(i);
        }
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 201; i < 300; i++) {
            System.out.println(i);
        }
    }
}