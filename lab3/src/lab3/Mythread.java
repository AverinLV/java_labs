package lab3;

public class Mythread {
public static void main(String args[]) throws InterruptedException {
byte cycle_arg = -1;
Object common_monitor = new Object();

if (args.length == 1)
{
    try {
        cycle_arg = Byte.parseByte(args[0]);
        System.out.println("Cycle argument = " + cycle_arg);

        try {
            Write thread1 = new Write(cycle_arg, common_monitor);
            Read thread2 = new Read(cycle_arg, common_monitor);
           
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

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