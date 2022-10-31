package multithreading.prog;

import multithreading.prog.models.Buyer;
import multithreading.prog.models.Share;
import multithreading.prog.thread.BrokerThread;
import multithreading.prog.thread.ExchangeThread;
import multithreading.prog.util.Utility;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Share shares1 = new Share("AAPL", 100, 141);
        Share shares2 = new Share("COKE", 1000, 387);
        Share shares3 = new Share("IBM", 200, 137);

        Buyer buyer1 = new Buyer("Alice", new Share[]{
                new Share("AAPL", 10, 100),
                new Share("COKE", 20, 390)
        });

        Buyer buyer2 = new Buyer("Bob", new Share[]{
                new Share("AAPL", 10, 140),
                new Share("IBM", 20, 135)
        });

        Buyer buyer3 = new Buyer("Charlie", new Share[]{
                new Share("COKE", 300, 370)
        });

        ArrayList<Share> shareArrayList = new ArrayList<>(3);
        shareArrayList.add(shares1);
        shareArrayList.add(shares2);
        shareArrayList.add(shares3);

        ArrayList<Buyer> customerArrayList = new ArrayList<>(3);
        customerArrayList.add(buyer1);
        customerArrayList.add(buyer2);
        customerArrayList.add(buyer3);

        ExchangeThread runnableShare = null;
        for (Share share : shareArrayList
        ) {
            runnableShare = new ExchangeThread(share);
            Thread thread = new Thread(runnableShare);
            thread.setName("thread-exchange-" + share.getName());
            thread.start();
        }

        BrokerThread runnableBroker = null;
        for (Buyer customer : customerArrayList
        ) {
            runnableBroker = new BrokerThread(customer, shareArrayList);
            Thread thread = new Thread(runnableBroker);
            thread.setName("thread-broker-" + customer.getName());
            thread.start();
        }

        Utility.threadSleep(60);

        runnableShare.disable();
        runnableBroker.disable();

        for (Share share : shareArrayList) {
            Utility.printDetailData("FINISH" + " object " + share);
        }
    }
}
