package multithreading.prog.thread;

import multithreading.prog.util.Utility;
import multithreading.prog.models.Customer;
import multithreading.prog.models.Share;

import java.util.ArrayList;

public class BrokerThread implements Runnable, Disable {

    private final Customer customer;
    private final ArrayList<Share> shareArrayList;
    private volatile static boolean activity;

    public BrokerThread(Customer customer, ArrayList<Share> shareArrayList) {
        this.customer = customer;
        this.shareArrayList = shareArrayList;
        activity = true;
    }

    @Override
    public void run() {
        while (activity) {
            for (int i = 0; i < customer.getTarget().length; i++) {
                for (Share share : shareArrayList) {
                    if (customer.getTarget()[i].getName().equals(share.getName())) {
                        synchronized (shareArrayList) {
                            if (customer.getTarget()[i].getAmount() <= share.getAmount() &&
                                    customer.getTarget()[i].getPrice() >= share.getPrice()) {

                                share.setAmount(share.getAmount() - customer.getTarget()[i].getAmount());

                                Utility.printDetailData("You try to buy shares by name: " +
                                        customer.getTarget()[i].getName() +
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
                                        " Amounts in shares not enough | Price in customer not enough. Your attempt to buy shares not successful...");
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
