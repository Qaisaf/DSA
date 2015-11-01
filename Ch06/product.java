// product.java
// multiplies two numbers via recursive addition
// calculates the power of a number via recursive multiplication
// to run this program: C>java ProductApp
import java.io.*;
////////////////////////////////////////////////////////////////
class ProductApp
   {
   static int theNumber;
   static int n1;
   static int n2;

   public static void main(String[] args) throws IOException
      {
      String egress = "y";
      
      while(!"n".equalsIgnoreCase(egress))
      {
        System.out.println("Enter two numbers to calculate their product.");
        System.out.print("Enter number: ");
        n1 = getInt();
        System.out.print(n1+" multiplied by: ");
        n2 = getInt();
        int theProduct = multiply(n1, n2);
        System.out.println(n1+" x "+n2+" = "+theProduct+"\n");


        System.out.println("Calculate the power of a number.");
        System.out.print("Enter number: ");
        n1 = getInt();
        System.out.print(n1+" to the power of: ");
        n2=getInt();
        int thePower = power(n1, n2);
        System.out.println(n1+" to the power of "+n2+" equals "+thePower+"\n");
        
        System.out.println("Would you like to go again? (Enter n to quit)");
        egress=getString();
      }
      
      }  // end main()
//-------------------------------------------------------------
   public static int multiply(int n1, int n2)
   {
       
       if(n2==1)
           return n1;
       else if(n2 == -1)
           return n1;
       else if(n2 == 0 || (n1==0))
           return 0;
       else if(n2>0)
           return (n1 + multiply(n1, --n2));
       else
           return (n1 - multiply(n1, ++n2));
   }
   
   public static int power(int nmbr, int pwr)
   {
       if(pwr==1)
           return nmbr;
       else
       {
           return (nmbr*power(nmbr, --pwr));
           //return (multiply(nmbr, power(nmbr,--pwr)));
       }
   }
//-------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
//--------------------------------------------------------------
   }  // end class TriangleApp
////////////////////////////////////////////////////////////////
