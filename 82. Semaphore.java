import java.util.concurrent.Semaphore;

class Semaphoree {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);

        new Person("Tanita", callBox);
        new Person("Bob", callBox);
        new Person("Kit", callBox);
        new Person("John", callBox);
        new Person("Bill", callBox);
    }
}

class Person extends Thread {
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " waiting");
            callBox.acquire();
            System.out.println(name + " use phone");
            sleep(2000);
            System.out.println(name + " end call");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            callBox.release();
        }
    }
}


