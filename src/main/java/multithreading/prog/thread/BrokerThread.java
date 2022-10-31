package multithreading.prog.thread;

import multithreading.prog.util.Utility;
import multithreading.prog.models.Buyer;
import multithreading.prog.models.Share;

import java.util.ArrayList;

public class BrokerThread implements Runnable, Disable {

    private final Buyer buyer;
    private final ArrayList<Share> shareArrayList;
    private volatile static boolean activity;

    public BrokerThread(Buyer buyer, ArrayList<Share> shareArrayList) {
        this.buyer = buyer;
        this.shareArrayList = shareArrayList;
        activity = true;
    }

    @Override
    public void run() {
        while (activity) {
            for (int i = 0; i < buyer.getTarget().length; i++) {
                for (Share share : shareArrayList) {
                    if (buyer.getTarget()[i].getName().equals(share.getName())) {
                        synchronized (shareArrayList) {
                            if (buyer.getTarget()[i].getAmount() <= share.getAmount() &&
                                    buyer.getTarget()[i].getPrice() >= share.getPrice()) {

                                share.setAmount(share.getAmount() - buyer.getTarget()[i].getAmount());

                                Utility.printDetailData("You try to buy shares by name: " +
                                        buyer.getTarget()[i].getName() +
                                        ", which price: " +
                                        share.getPrice() +
                                        " Your attempt to buy shares successful." +
                                        ", current amount in shape:" +
                                        share.getAmount());
                            } else {
                                Utility.printDetailData("You try to buy shares by name: " +
                                        share.getName() +
                                        ", which price: " +
                                        share.getPrice() +
                                        " Your attempt to buy shares not successful...");
                            }
                        }
                    }
                }
                Utility.threadSleep(5);
            }
        }
    }

    @Override
    public void disable() {
        activity = false;
    }
}
