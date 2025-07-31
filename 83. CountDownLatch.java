import java.util.concurrent.CountDownLatch;

class CountDownLatchhh {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        new Friend("Tanita", countDownLatch);
        new Friend("Tanita1", countDownLatch);
        new Friend("Tanita2", countDownLatch);
        new Friend("Tanita3", countDownLatch);
        new Friend("Tanita4", countDownLatch);

        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();
    }

    private static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Staff came to work");
        countDownLatch.countDown();
        System.out.println("cdl " + countDownLatch.getCount());
    }

    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("everythingIsReady");
        countDownLatch.countDown();
        System.out.println("cdl " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is open");
        countDownLatch.countDown();
        System.out.println("cdl " + countDownLatch.getCount());
    }
}

class Friend extends Thread {
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    public void run(){
        try {
            countDownLatch.await();
            System.out.println(name + " start to buy");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
