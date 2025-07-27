import java.util.concurrent.*;

class CallableFuture {
    static int factorialResult;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CallableFactorial factorial = new CallableFactorial(6);
        Future<Integer> future = executorService.submit(factorial);
        try {
            factorialResult = future.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);

    }
}

//class Factorial implements Runnable {
//    int f;
//
//    public Factorial(int f) {
//        this.f = f;
//    }
//
//    @Override
//    public void run() {
//        if (f <=0 ) {
//            System.out.println("wrong number");
//        }
//        int result = 1;
//        for (int i = 1; i <= f; i++) {
//            result *= i;
//        }
//        CallableFuture.factorialResult = result;
//
//    }
//}

class CallableFactorial implements Callable<Integer> {
    int f;

    public CallableFactorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f <= 0) {
            throw new Exception("Wrong value");
        }

        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        return result;
    }
}