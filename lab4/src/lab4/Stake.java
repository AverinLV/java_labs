package lab4;

import java.util.concurrent.Semaphore;

class Stake extends Thread {
byte cycle_arg = -1;
static Semaphore semaphore = new Semaphore(0);

Stake(byte cycle_arg) {
	this.cycle_arg = cycle_arg;
	this.setName("Tie-man");
}

public void run() {

for (int i = 1; i <= cycle_arg; i++) {
	try {
		semaphore.acquire();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    	System.out.println(Thread.currentThread().getName() + "  - let me tie it to a stake");
        Pit.semaphore.release();
	}
}
}