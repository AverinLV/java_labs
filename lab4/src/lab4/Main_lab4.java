package lab4;

public class Main_lab4 {

	public static void main(String args[]) throws InterruptedException {
		byte cycle_arg = -1;
		
		if (args.length == 1)
		{
		    try {
		        cycle_arg = Byte.parseByte(args[0]);
		        System.out.println("Let's plant " + cycle_arg + " trees.");

		        try {
		            Pit thread1 = new Pit(cycle_arg);
		            Tree thread2 = new Tree(cycle_arg);
		            Stake thread3 = new Stake(cycle_arg);

		            thread1.start();
		            thread2.start();
		            thread3.start();
		            thread1.join();
		            thread2.join();
		            thread3.join();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    } catch (Exception ex) {
		        System.out.println("Error. Not numeric. ");
		    }
		} else
		    System.out.println("Error. More than 1 argument. ");
	}
}
