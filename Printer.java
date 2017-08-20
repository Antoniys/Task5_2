package Task5_2;

public class Printer implements Runnable {
    Increment inc;


    public Printer(Increment inc) {
        this.inc = inc;
        new Thread(this).start();
    }

    @Override
    public void run() {
        synchronized (inc) {
            while (inc.value < 1000000) {
                inc.notify();
                System.out.println(inc.value);
                try {
                    inc.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            inc.notify();
        }

    }
}
