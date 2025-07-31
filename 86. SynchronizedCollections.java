import java.util.*;

class SynchronizedCollections {
    public static void main(String[] args) throws InterruptedException {
//        List<Integer> sourder = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            sourder.add(i);
//        }
////        List<Integer> target = new ArrayList<>();
//        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
//        Runnable runnable = () -> syncList.addAll(sourder);
//
//        Thread th1 = new Thread(runnable);
//        Thread th2 = new Thread(runnable);
//        th1.start();
//        th2.start();
//        th1.join();
//        th2.join();
//        System.out.println(syncList);

        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
        List<Integer> syncList = Collections.synchronizedList(arrayList);
        Runnable runnable = () -> {
            synchronized (syncList){
            Iterator<Integer> itarator = syncList.iterator();
            while (itarator.hasNext()) {
                itarator.next();
                System.out.println(itarator.next());
            }}
        };
        Runnable runnable2 = () -> syncList.remove(10);

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable2);
        th1.start();
        th2.start();
        th1.join();
        th2.join();

        System.out.println(syncList);
    }

}
