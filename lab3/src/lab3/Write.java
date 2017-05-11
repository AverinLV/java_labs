package lab3;

class Write extends Thread {
static byte num = -1;
static byte cycle_arg = -1;
Object monitor;

Write(byte cycle_arg, Object _monitor) {
	Write.cycle_arg = cycle_arg;
	this.setName("Write thread");
	monitor = _monitor;
}

public void rand_number() {
	num = (byte) (Math.random() * 50);
	System.out.println(Thread.currentThread().getName() + " wrote " + num);
}

public void run() {
for (int i = 1; i <= cycle_arg; i++) {

        synchronized (monitor) {
            rand_number();
            monitor.notify();
            try {
                if (i < cycle_arg)
                    monitor.wait();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}
}
}