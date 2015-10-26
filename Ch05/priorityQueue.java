// linkQueue.java
// demonstrates queue implemented as double-ended list
// to run this program: C>java LinkQueueApp
////////////////////////////////////////////////////////////////
class Link
   {
   public long dData;                // data item
   public Link next;                 // next link in list
// -------------------------------------------------------------
   public Link(long d)               // constructor
      { dData = d; }
// -------------------------------------------------------------
   public void displayLink()         // display this link
      { System.out.print(dData + " "); }
// -------------------------------------------------------------
   }  // end class Link
////////////////////////////////////////////////////////////////
class SortedList
   {
   private Link first;               // ref to first item
   private Link last;                // ref to last item
// -------------------------------------------------------------
   public SortedList()            // constructor
      {
      first = null;                  // no items on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
   public void insertLast(long key) // insert at end of list
      {
      Link newLink = new Link(key);   // make new link
      Link previous = null;
      Link current = first;
      while(current != null && key > current.dData)
      {
          previous = current;
          current = current.next;
      }
      if(previous==null)
      {
          first = newLink;
      }
      else
      {
          previous.next = newLink;
      }
      newLink.next = current;                // newLink <-- last
      }
// -------------------------------------------------------------
   public Link remove()
   {
       Link temp = first;
       first = first.next;
       return temp;
   }
// -------------------------------------------------------------
   public void displayList()
      {
      Link current = first;          // start at beginning
      while(current != null)         // until end of list,
         {
         current.displayLink();      // print data
         current = current.next;     // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class FirstLastList
////////////////////////////////////////////////////////////////
class PriorityQueue
   {
   private SortedList queue;
//--------------------------------------------------------------
   public PriorityQueue()                // constructor
      { queue = new SortedList(); }  // make a 2-ended list
//--------------------------------------------------------------
   public boolean isEmpty()          // true if queue is empty
      { return queue.isEmpty(); }
//--------------------------------------------------------------
   public void insert(long j)        // insert, rear of queue
      { queue.insertLast(j); }
//--------------------------------------------------------------
   public Link remove()              // remove, front of queue
      {  return queue.remove();  }
//--------------------------------------------------------------
   public void displayQueue()
      {
      System.out.print("Queue (front-->rear): ");
      queue.displayList();
      }
//--------------------------------------------------------------
   }  // end class LinkQueue
////////////////////////////////////////////////////////////////
class PriorityQueueApp
   {
   public static void main(String[] args)
      {
      PriorityQueue pQueue = new PriorityQueue();
      System.out.println("Inserting two values...");
      pQueue.insert(20);                 // insert items
      pQueue.insert(40);

      pQueue.displayQueue();             // display queue
      
      System.out.println("Inserting two more values...");
      pQueue.insert(60);                 // insert items
      pQueue.insert(80);

      pQueue.displayQueue();             // display queue
      
      System.out.println("Removing two values...");
      pQueue.remove();                   // remove items
      pQueue.remove();

      pQueue.displayQueue();             // display queue
      }  // end main()
   }  // end class LinkQueueApp
////////////////////////////////////////////////////////////////
