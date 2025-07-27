import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ThreadPoolExecuterService {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImpl());
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MILLISECONDS);
        System.out.println("Main ends");
    }
}

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins") ;
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("ends");
    }
}
