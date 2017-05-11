package lab3;

class Read extends Thread {
byte cycle_arg = -1;

Write write;
Object monitor;

Read(byte cycle_arg, Object _monitor) {
	this.cycle_arg = cycle_arg;
	this.setName("Read thread");
	monitor = _monitor;
}

public void run() {
for (int i = 1; i <= cycle_arg; i++) {
	
        synchronized (monitor) {
        	System.out.println(Thread.currentThread().getName() + " read " + Write.num);
            monitor.notify();
            try {
                if (i < cycle_arg)
                    monitor.wait();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
}
}
}