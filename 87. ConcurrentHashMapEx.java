import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class ConcurrentHashMapEx {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Bob1");
        map.put(2, "Bob2");
        map.put(3, "Bob3");
        map.put(4, "Bob4");
        map.put(5, "Bob5");
        System.out.println(map);

        Runnable runnable = () -> {
            Iterator<Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i = iterator.next();
                System.out.println(map.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            map.put(6, "Elena");
        };

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable2);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println();

    }

}
