package lab4;

import java.util.concurrent.Semaphore;

class Tree extends Thread {
byte cycle_arg = -1;
static Semaphore semaphore = new Semaphore(0);

Tree(byte cycle_arg) {
	this.cycle_arg = cycle_arg;
	this.setName("Planter");
}

public void run() {

for (int i = 1; i <= cycle_arg; i++) {
	try {
		semaphore.acquire();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    	System.out.println(Thread.currentThread().getName() + "  - I am planting a tree");
        Stake.semaphore.release();
	}
}
}