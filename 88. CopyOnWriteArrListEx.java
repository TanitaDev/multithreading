import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class CopyOnWriteArrListEx {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
        arrayList.add("name1");
        arrayList.add("name2");
        arrayList.add("name3");
        arrayList.add("name4");
        arrayList.add("name5");

        Runnable runnable = () -> {
            Iterator<String> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(iterator.next());
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            arrayList.remove(4);
            arrayList.add("Elena");
        };

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable2);
        th1.start();
        th2.start();
        th1.join();
        th2.join();

        System.out.println(arrayList);

    }
}
