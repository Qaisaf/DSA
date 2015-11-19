// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp
import java.io.*;
import java.util.*;               // for Stack class
////////////////////////////////////////////////////////////////
class Node
   {
   public String iData;              // data item (key)          // data item
   public Node leftChild;         // this node's left child
   public Node rightChild;        // this node's right child

   public void displayNode()      // display ourself
      {
      System.out.print('{');
      System.out.print(iData);
      System.out.print("} ");
      }
   }  // end class Node
////////////////////////////////////////////////////////////////
class Tree
   {
   private Node root;             // first node of tree
   public void setNode(Node newNode)
   {
       root = newNode;
   }
   public Node getNode()
   {
       return root;
   }

// -------------------------------------------------------------
   public Tree()                  // constructor
      { root = null; }            // no nodes in tree yet

// -------------------------------------------------------------
   public void traverse(int traverseType)
      {
      switch(traverseType)
         {
         case 1: System.out.print("\nPreorder traversal: ");
                 preOrder(root);
                 break;
         case 2: System.out.print("\nInorder traversal:  ");
                 inOrder(root);
                 break;
         case 3: System.out.print("\nPostorder traversal: ");
                 postOrder(root);
                 break;
         }
      System.out.println();
      }
// -------------------------------------------------------------
   private void preOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         System.out.print(localRoot.iData + " ");
         preOrder(localRoot.leftChild);
         preOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void inOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         inOrder(localRoot.leftChild);
         System.out.print(localRoot.iData + " ");
         inOrder(localRoot.rightChild);
         }
      }
// -------------------------------------------------------------
   private void postOrder(Node localRoot)
      {
      if(localRoot != null)
         {
         postOrder(localRoot.leftChild);
         postOrder(localRoot.rightChild);
         System.out.print(localRoot.iData + " ");
         }
      }
// -------------------------------------------------------------
   public void displayTree()
      {
      Stack globalStack = new Stack();
      globalStack.push(root);
      int nBlanks = 32;
      boolean isRowEmpty = false;
      System.out.println(
      "......................................................");
      while(isRowEmpty==false)
         {
         Stack localStack = new Stack();
         isRowEmpty = true;

         for(int j=0; j<nBlanks; j++)
            System.out.print(' ');

         while(globalStack.isEmpty()==false)
            {
            Node temp = (Node)globalStack.pop();
            if(temp != null)
               {
               System.out.print(temp.iData);
               localStack.push(temp.leftChild);
               localStack.push(temp.rightChild);

               if(temp.leftChild != null ||
                                   temp.rightChild != null)
                  isRowEmpty = false;
               }
            else
               {
               System.out.print("--");
               localStack.push(null);
               localStack.push(null);
               }
            for(int j=0; j<nBlanks*2-2; j++)
               System.out.print(' ');
            }  // end while globalStack not empty
         System.out.println();
         nBlanks /= 2;
         while(localStack.isEmpty()==false)
            globalStack.push( localStack.pop() );
         }  // end while isRowEmpty is false
      System.out.println(
      "......................................................");
      }  // end displayTree()
// -------------------------------------------------------------
   }  // end class Tree
////////////////////////////////////////////////////////////////

class Leaves //function to enter single node trees into a larger tree
{
    public static void enterLetters(Node localRoot, Tree[] nodeTree, int i)
    {
        if(localRoot != null && i<nodeTree.length)
        {
            if(nodeTree.length-2 == i)
            {
                localRoot.leftChild = nodeTree[i].getNode();
                localRoot.rightChild = nodeTree[i+1].getNode();
                return;
            }
            else
            {
                Node plusNode = new Node();
                plusNode.iData = "+";
                localRoot.leftChild = plusNode;
                localRoot.rightChild = nodeTree[i].getNode();
                enterLetters(localRoot.leftChild, nodeTree, i+1);
            }
        }
    }
}

class TreeApp
   {
   public static void main(String[] args) throws IOException
      {
          Tree[] forest = new Tree[5];
          
          Scanner sc = new Scanner(System.in);
          
          for(int i = 0; i<forest.length; i++)
          {
              String letter;
              forest[i] = new Tree();
              System.out.print("Enter a letter: ");
              letter = getString();
              
              Node newNode = new Node();
              newNode.iData = letter;
              forest[i].setNode(newNode);
          }
          
          Tree letterTree = new Tree();
          Node firstNode = new Node();
          firstNode.iData = "+";
          letterTree.setNode(firstNode);
          
          Leaves.enterLetters(letterTree.getNode(), forest, 0);
          
          letterTree.displayTree();
      }  // end main()
// -------------------------------------------------------------

   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
// -------------------------------------------------------------
   public static char getChar() throws IOException
      {
      String s = getString();
      return s.charAt(0);
      }
//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
// -------------------------------------------------------------
   }  // end class TreeApp

////////////////////////////////////////////////////////////////
