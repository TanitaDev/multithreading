import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockReentrantLock {
    public static void main(String[] args) {
        Call call = new Call();

        Thread th = new Thread((() -> call.phoneCall()));

        Thread th2 = new Thread((() -> call.skypeCall()));

        Thread th3 = new Thread((() -> call.whatsAppCall()));

        th.start();
        th2.start();
        th3.start();
    }

}

class Call {
    static final Lock lock = new ReentrantLock();

    void phoneCall() {
        lock.lock();
        try {
            System.out.println("Phone call starts");
            Thread.sleep(3000);
            System.out.println("Phone call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    void skypeCall() {
        lock.lock();
        try {
            System.out.println("skypeCall call starts");
            Thread.sleep(5000);
            System.out.println("skypeCall call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    void whatsAppCall() {
        lock.lock();
        try {
            System.out.println("whatsAppCall call starts");
            Thread.sleep(7000);
            System.out.println("whatsAppCall call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}

