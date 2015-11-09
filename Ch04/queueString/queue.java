// Queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
   public void insert(long j)   // put item at rear of queue
      {
      if(rear == maxSize-1)         // deal with wraparound
         rear = -1;
      queArray[++rear] = j;         // increment rear and insert
      nItems++;                     // one more item
      }
//--------------------------------------------------------------
   public long remove()         // take item from front of queue
      {
      long temp = queArray[front++]; // get value and incr front
      if(front == maxSize)           // deal with wraparound
         front = 0;
      nItems--;                      // one less item
      return temp;
      }
//--------------------------------------------------------------
   public long peekFront()      // peek at front of queue
      {
      return queArray[front];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // number of items in queue
      {
      return nItems;
      }
//--------------------------------------------------------------
   /*@Override //output Queue contents to string
   public String toString()
   {
       StringBuilder output = new StringBuilder();
       String NEW_LINE = System.getProperty("line.separator");
       String EMPTY = "No items in queue";
       
       if(this.isEmpty()) //base case
       {
           output.append(EMPTY);
       }
       else
       {
           while(!this.isEmpty())
           {
               output.append(this.remove()).append(NEW_LINE);
           }
       }
       
       return output.toString();
   }*/
   
   public String display()
   {
       StringBuilder output = new StringBuilder();
       String NEW_LINE = System.getProperty("line.separator");
       String EMPTY = "No items in queue";
       
       if(this.isEmpty())
       {
           output.append(EMPTY);
       }
       else
       {
           for(int i = 0; i<nItems; i++)
           {
               output.append(queArray[(front+i)%maxSize]).append(NEW_LINE);
           }
       }
       
       return output.toString();
   }
   }  // end class Queue

class QueueTwo
{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    
    public QueueTwo(int s)
    {
        maxSize = s+1;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }
    
    public void insert(long j)
    {
        if(rear==maxSize-1)
            rear = -1;
        queArray[++rear]=j;
    }
    
    public long remove()
    {
        long temp = queArray[front++];
        if(front==maxSize)
            front = 0;
        return temp;
    }
    
    public long peek()
    {
        return queArray[front];
    }
    
    public boolean isEmpty()
    {
        return (rear+1==front || (front+maxSize-2==rear));
    }
}
////////////////////////////////////////////////////////////////
class QueueApp
   {
   public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items

      theQueue.insert(10);            // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);

      theQueue.remove();              // remove 3 items
      theQueue.remove();              //    (10, 20, 30)
      theQueue.remove();

      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);
      
      //System.out.println(theQueue);
      System.out.println("Displaying items:");
      System.out.println(theQueue.display());
      System.out.println("Displaying items again to show they were not removed:");
      System.out.println(theQueue.display());
      
      QueueTwo qq = new QueueTwo(5);
      System.out.println(qq.isEmpty());
      qq.insert(10);
      qq.insert(20);
      qq.insert(30);
      qq.insert(40);
      qq.insert(50);
      
      qq.remove();
      qq.remove();
      qq.remove();
      System.out.println(qq.isEmpty());
      qq.insert(60);
      qq.insert(70);
      qq.insert(80);
      
      System.out.println(qq.isEmpty());
      
      for(int i = 0; i<5; i++)
      {
          qq.remove();
      }
      
      System.out.println(qq.isEmpty());

      /*while( !theQueue.isEmpty() )    // remove and display
         {                            //    all items
         long n = theQueue.remove();  // (40, 50, 60, 70, 80)
         System.out.print(n);
         System.out.print(" ");
         }
      System.out.println("");*/
      }  // end main()
   }  // end class QueueApp
////////////////////////////////////////////////////////////////
