// partition.java
// demonstrates partitioning an array
// to run this program: C>java PartitionApp
////////////////////////////////////////////////////////////////
class ArrayPar
   {
   private long[] theArray;          // ref to array theArray
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayPar(int max)          // constructor
      {
      theArray = new long[max];      // create the array
      nElems = 0;                    // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      theArray[nElems] = value;      // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public int size()                 // return number of items
      { return nElems; }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      System.out.print("A=");
      for(int j=0; j<nElems; j++)    // for each element,
         System.out.print(theArray[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
    public int partitionIt(int left, int right, long pivot)
       {
       int leftPtr = left - 1;           // right of first elem
       int rightPtr = right + 1;         // left of pivot
       while(true)
          {
          while(leftPtr < right &&       // find bigger item
                theArray[++leftPtr] < pivot)
             ;  // (nop)

          while(rightPtr > left &&       // find smaller item
                theArray[--rightPtr] > pivot)
             ;  // (nop)
          if(leftPtr >= rightPtr)        // if pointers cross,
             break;                      //    partition done
          else                           // not crossed, so
             swap(leftPtr, rightPtr);    //    swap elements
          }  // end while(true)
       return leftPtr;                   // return partition
       }  // end partitionIt()
//--------------------------------------------------------------
   public void swap(int dex1, int dex2)  // swap two elements
      {
      long temp;
      temp = theArray[dex1];             // A into temp
      theArray[dex1] = theArray[dex2];   // B into A
      theArray[dex2] = temp;             // temp into B
      }  // end swap()
//--------------------------------------------------------------   
   public long pivot()                  //returns the pivot in a partition
   {
       return theArray[size()-1];
   }
//--------------------------------------------------------------
   }  // end class ArrayPar
////////////////////////////////////////////////////////////////
class PartitionApp
   {
   public static void main(String[] args)
      {
      int maxSize = 16;             // array size
      ArrayPar arr;                 // reference to array
      arr = new ArrayPar(maxSize);  // create the array

      
      arr.insert(107);
      arr.insert(67);
      arr.insert(187);
      arr.insert(126);
      arr.insert(53);
      arr.insert(187);
      arr.insert(121);
      arr.insert(17);
      arr.insert(187);
      arr.insert(28);
      arr.insert(94);
      arr.insert(185);
      arr.insert(126);
      arr.insert(48);
      arr.insert(108);
      arr.insert(45);
      arr.display();                // display unsorted array

      long pivot = arr.pivot();              // pivot value
      System.out.print("Pivot is " + pivot);
      int size = arr.size();
                                    // partition array
      int partDex = arr.partitionIt(0, size-1, pivot);

      System.out.println(", Partition is at index " + partDex);
      arr.display();                // display partitioned array
      
      System.out.println();
      
    ///////////////////////////////////////////////////////////////
      //Array 2, randomly generated numbers
      
      ArrayPar arr2 = new ArrayPar(maxSize);
      
      for(int j=0; j<maxSize; j++)  // fill array with
         {                          // random numbers
         long n = (int)(java.lang.Math.random()*199);
         arr2.insert(n);
         }
      arr2.display();
      
      pivot = arr2.pivot();
      
      System.out.print("Pivot is "+pivot);
      
      size = arr2.size();
      partDex = arr2.partitionIt(0, size-1, pivot);
      
      System.out.println(", Partition is at index "+partDex);
      arr2.display();
      
      System.out.println();
      
    ///////////////////////////////////////////////////////////////
      //Array 3, array length of 3
      maxSize = 3;
      
      ArrayPar arr3 = new ArrayPar(maxSize);
      
      for(int j=0; j<maxSize; j++)  // fill array with
         {                          // random numbers
         long n = (int)(java.lang.Math.random()*199);
         arr3.insert(n);
         }
      arr3.display();
      
      pivot = arr3.pivot();
      
      System.out.print("Pivot is "+pivot);
      
      size = arr3.size();
      partDex = arr3.partitionIt(0, size-1, pivot);
      
      System.out.println(", Partition is at index "+partDex);
      arr3.display();
      System.out.println();
      
      ///////////////////////////////////////////////////////////////
      //Array 3, array length of 3
      maxSize = 2;
      
      ArrayPar arr4 = new ArrayPar(maxSize);
      
      for(int j=0; j<maxSize; j++)  // fill array with
         {                          // random numbers
         long n = (int)(java.lang.Math.random()*199);
         arr4.insert(n);
         }
      arr4.display();
      
      pivot = arr4.pivot();
      
      System.out.print("Pivot is "+pivot);
      
      size = arr4.size();
      partDex = arr4.partitionIt(0, size-1, pivot);
      
      System.out.println(", Partition is at index "+partDex);
      arr4.display();
      }  // end main()
   }  // end class PartitionApp
////////////////////////////////////////////////////////////////
