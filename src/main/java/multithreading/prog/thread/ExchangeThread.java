package multithreading.prog.thread;

import multithreading.prog.util.Utility;
import multithreading.prog.models.Share;

public class ExchangeThread implements Runnable, Disable {
    /**
     * Use object as such as lock and also object who save data
     */
    private final Share share;
    private volatile static boolean activity;

    public ExchangeThread(Share share) {
        this.share = share;
        activity = true;
    }

    @Override
    public void run() {
        while (activity) {
            synchronized (share) {
                share.setPrice(changePrice(share.getPrice()));
                Utility.printDetailData(share.toString());
                Utility.threadSleep(30);
            }
        }
    }

    /**
     * @return double values price this object within 3%
     */
    private double changePrice(double price) {
        double max = price + (price * 0.03);
        double min = price - (price * 0.03);

        return Math.floor(Math.random() * (max - min + 1) + min);
    }

    @Override
    public void disable() {
        activity = false;
    }
}
