package lab2;
import java.util.Random;
import java.util.Scanner;

public class Main_lab2 {
	public static void main(String[] args) throws InterruptedException {
		byte cycle_arg = -1;
		if (args.length == 1)
		{
		    try {
		        cycle_arg = Byte.parseByte(args[0]);
		        System.out.println("Cycle argument = " + cycle_arg);

		        try {
			    	Creep [] obj = new Creep[cycle_arg];	
			    	
			    	for (int i=0;i<obj.length;i++){
			    		Random rand = new Random();
			    		int  n = rand.nextInt(50) + 1;
			    			if (n%2 == 0) { 
			    				Dog c = new Dog();
			    				obj [i] = c;
			    			}
			    			else {
			    				Snake c = new Snake();
			    				obj [i] = c;
			    			}
			    	}
			      
			    	for (int i=0;i<obj.length;i++){
			    		((Creature) obj[i]).my_number(i);
			    		obj[i].whoami();
			    		
			    		if (obj[i] instanceof Dog) obj[i].creep();
			    		else ((Snake) obj[i]).wriggle();
			    	}

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    } catch (Exception ex) {
		        System.out.println("Error. Not numeric. ");
		    }
		} else
		    System.out.println("Error. More than 1 argument. ");
		}
/*		int a = 1;
		int j = 1;
	    Scanner s= new Scanner(System.in);
	    
	    while (j!=0){
	    	if(s.hasNextInt()){
	    		a=s.nextInt();
	    		j = j-1;
	    	}else{
	    		System.out.println("type only integers, please");
	    		s.next();
	    	}
	    	}
	      	
	    	s.close();
	    	System.out.println(a);

	    	Creep [] obj = new Creep[a];	
	    	
	    	for (int i=0;i<obj.length;i++){
	    		Random rand = new Random();
	    		int  n = rand.nextInt(50) + 1;
	    			if (n%2 == 0) { 
	    				Dog c = new Dog();
	    				obj [i] = c;
	    			}
	    			else {
	    				Snake c = new Snake();
	    				obj [i] = c;
	    			}
	    	}
	      
	    	for (int i=0;i<obj.length;i++){
	    		System.out.println(obj[i]);
	    		((Creature) obj[i]).my_number(i);
	    		obj[i].whoami();
	    		
	    		if (obj[i] instanceof Dog) obj[i].creep();
	    		else ((Snake) obj[i]).wriggle();
	    	}*/
	}
