package Task5_2;

public class Counter implements Runnable {
    Increment inc;


    public Counter(Increment inc) {
        this.inc = inc;
        new Thread(this).start();
    }

    @Override
    public void run() {
        synchronized (inc) {
            while (inc.value < 1000000) {
                inc.notify();
                try {
                    inc.value++;
                    inc.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

