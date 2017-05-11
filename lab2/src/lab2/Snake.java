package lab2;

public class Snake extends Creature implements Wriggle{
	   public void wriggle() {
		   System.out.println("i can wriggle");
	   }
	   
	   public void whoami() {
		   System.out.println("i am snake");
	   }

	@Override
	public void creep() {System.out.println("i cannot creep");}
}
