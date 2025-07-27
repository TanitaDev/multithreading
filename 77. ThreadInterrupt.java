class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");

        InterruptThread interruptThread = new InterruptThread();
        interruptThread.start();
        Thread.sleep(2000);
        interruptThread.interrupt();
        interruptThread.join();

        System.out.println("main ends");
    }

}

class InterruptThread extends Thread {
    double sqrtSum = 0;

    @Override
    public void run() {
        for (int i = 0; i <= 1000000000 ; i++) {
            if (isInterrupted()) {
                System.out.println("try interrupt");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Поток хотят прервать во время сна");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}