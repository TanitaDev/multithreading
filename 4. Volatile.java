class Volatile extends Thread{
    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile volExp = new Volatile();
        volExp.start();

        Thread.sleep(3000);
        System.out.println("wake up");
        volExp.b = false;
        volExp.join();
        System.out.println("end of program");
    }

}
