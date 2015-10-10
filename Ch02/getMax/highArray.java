
import java.util.Scanner;

// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   public long getMax() //returns the highest key value
    {
       long max = -1;
       
       for(long num: a)
       {
           max = num>max?num:max;
           /*if(num>max)
           {
               max = num;
           }    */
       }

       return max;
    }
   /*returns and removes the highest key value.
   if the array is empty, returns 0
   */
   public long removeMax()
   {
       long max = 0;
       for(int i=0; i<nElems; i++)
       {
           //max=num>max?num:max;
           if(a[i]>max)
           {
               max=a[i];
           }
       }
       if(max>-1)
           delete(max);
       
       return max;
   }
   //------------------------------------------------------------
   public void bubbleSort()
   {
       int outerbound, position;
       for(outerbound=nElems-1; outerbound>1; outerbound--)
       {
           for(position=0; position<outerbound; position++)
           {
               if(a[position]>a[position+1])
               {
                   swap(position,position+1);
               }
           }
       }
   }
   //------------------------------------------------------------
   public void swap(int one, int two)
   {
       long temp = a[one];
       a[one]=a[two];
       a[two]=temp;
   }
   public int getLength()
   {
       return nElems;
   }
   }  // end class HighArray
////////////////////////////////////////////////////////////////
class HighArrayApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      HighArray arr;                // reference to array
      arr = new HighArray(maxSize); // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(92);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items
      
      long max = arr.getMax();
      if (max==-1)
          System.out.println("The array is empty");
      else
          System.out.println("Highest value: "+max);       //

      int searchKey = 35;           // search for item
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);
      
      System.out.println("Would you like the items sorted in inverse order? (y/n)");
      Scanner sc = new Scanner(System.in);
      String choice = sc.next();
      if(choice.contentEquals("y"))
      {
          HighArray nuArr = new HighArray(maxSize);
          int elems = arr.getLength();
          for(int i=0; i<elems;i++)
          {
              if(arr.getMax()>0)
                  nuArr.insert(arr.removeMax());
              else
                  break;
          }
          System.out.println("Displaying items sorted inversely.");
          nuArr.display();
      }

      System.out.println("Deleting three items.");
      arr.delete(00);               // delete 3 items
      arr.delete(55);
      arr.delete(92);

      arr.display();                // display items again
      }  // end main()
   }  // end class HighArrayApp
