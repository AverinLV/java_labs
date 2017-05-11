package lab1;
import java.util.Scanner;

public class Main_lab1 {
 
  static int nod;
 
  public static void main (String[]  args) {
     
      Scanner s= new Scanner(System.in);
      int [] a = new  int [3];
      for(int i=0;i<a.length;i++) {
    	  
    	  if(s.hasNextInt()){
    		   a[i]=s.nextInt();
    		}else{
    		   System.out.println("type only integers, please");
    		   s.next();
    		   i=i-1;
    		}
      }
      
      s.close();

      nod=gcd(a[0], a[1], a[2]);
      System.out.println("GCD of " +a[0]+ " , " +a[1]+ " , " +a[2]+ " = " +nod);
    
      }
         static int gcd(int a, int b, int c) {
         if(c==0) return a;
         else if (b==0) return gcd(c,b,a%c);
         else return gcd(b,a%b,c);
      }  
    }
