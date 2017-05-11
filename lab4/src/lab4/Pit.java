package lab4;

import java.util.concurrent.Semaphore;

class Pit extends Thread {
byte cycle_arg = -1;
static Semaphore semaphore = new Semaphore(1);

Pit(byte cycle_arg) {
	this.cycle_arg = cycle_arg;
	this.setName("Digger");
}

public void run() {

for (int i = 1; i <= cycle_arg; i++) {
	try {
		semaphore.acquire();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    	System.out.println(Thread.currentThread().getName() + "  - I dug a nice pit");
        Tree.semaphore.release();      
    }
}
}