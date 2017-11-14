package org.j2hongming.datastructure.sort;

class SleepSort implements Runnable {
    private int val;

    public SleepSort(int val) {
        this.val = val;
    }

    public void run() {
        try {
            Thread.sleep(val*10+10);
            System.out.println(Thread.currentThread().getName()+ ":" +val);
        } catch (InterruptedException e) {
            // Oops...
        }
    }
}
