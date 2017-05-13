package lab5;

//измененная лабораторная 1 без использования Scanner
public class lab1 {
	  static int nod;
	  
	  public static void main (int one, int two, int three) {
	     
	      nod=gcd(one, two, three);
	      System.out.println("GCD of " +one+ " , " +two+ " , " +three+ " = " +nod);
	    
	      }
	         static int gcd(int a, int b, int c) {
	         if(c==0) return a;
	         else if (b==0) return gcd(c,b,a%c);
	         else return gcd(b,a%b,c);
	      }  
}
