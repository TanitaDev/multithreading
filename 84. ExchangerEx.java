import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

class ExchangerEx {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.NOJNICI);
        friend1Action.add(Action.BUMAGA);
        friend1Action.add(Action.KAMEN);

        new BestFriend("Vanya", friend1Action, exchanger);
    }
}

enum Action {
    KAMEN, NOJNICI, BUMAGA
}

class BestFriend extends Thread {
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    private void whoWins(Action myAction,  Action friendsAction) {
        if ((myAction == Action.KAMEN && friendsAction == Action.NOJNICI) ||
        (myAction == Action.NOJNICI && friendsAction == Action.BUMAGA) ||
        (myAction == Action.BUMAGA && friendsAction == Action.KAMEN)) {
            System.out.println(name + " wins!");
        }
    }

    public void run() {
        Action reply;

        for (Action action: myActions) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
