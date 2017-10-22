//
//  Brenden Bickner 2017-01-26
//      Exercise 7
//
//  Minor syntax fixed from C++ to Java such as cout and public/private declarations

class SimpleList{                     // Create Class
    private class Node {                // Private Node
        public int item;
        public Node next;
    };
    
    public Node headM;
    public int sizeM;

    public SimpleList(){ this.headM = null; this.sizeM = 0;}    // Made two Constructors
    public SimpleList(Node n){headM = n; sizeM = 1;}
    
   // Don't need destructor as we have the Java garbage collector
   public static void main(String[] args){

    SimpleList list = new SimpleList();     // Create new list
    
    System.out.println("List just after creation -- is empty.");
    
    list.push_front(50);
    System.out.println("After calling push_front. list must have: 50");
    list.print();
    
    list.push_back(440);
    
    list.set(0,770);
    System.out.println("After calling push_back and set function list must have: 770  440");
    list.print();
    
    list.push_back(330);
    list.push_back(220);
    list.push_back(110);
    
    System.out.println("After three more calls to push_back, list must have:770, 440, 330, 220, 110");
    list.print();
    
    list.remove(0);
    list.remove(2);
    System.out.println("After removing two nodes. list must have: 440, 330, 110");
    list.print();
    list.insert(40, 3); //insert node with the value of 40 at the 4th position
    list.insert(20, -1); // do nothing
    list.insert(30, 30000); // do nothing
    list.insert(10, 0); //insert node with the value of 10 at the 1st position
    list.insert(33, 2); // insert node with the value 33 at the 3rd position
    
    System.out.println("Two  more nodes inserted, must have: 10, 440, 33, 330, 110, 40");
    list.print();
    
    list.remove(0);
    list.remove(1);
    list.remove(2);
    list.remove(3);   //These lines given do not make sense with your remove instructions
    list.remove(4);       //you want remove to take out a node thus making the list smaller.
    list.remove(5);       //therefore there is no 3rd element to remove
    System.out.println("After 6 removes, list must have: 440, 330, 40:");
    list.print();
    
    list.clear();
    System.out.println("After call to clear, list must be empty:");
    list.print();
    
    list.push_back(331);
    list.push_back(221);
    list.push_back(111);
    System.out.println("After three calls to push_back, list must have: 331, 221, 111");
    list.print();
   }
    public int size() {return this.sizeM;} 
    public void push_back(int item){    
 // PROMISES:
 //    Adds a node with an item to the end of the list, and increments sizeM
    Node last_node = this.headM;      
    if (last_node == null) {                // If empty list create a new node with an item
        this.headM = new Node();
        this.headM.item = item;
    }
    else{while(last_node.next != null){     // loop through nodes until found the last node
        last_node = last_node.next;
    }
    last_node.next = new Node();            // Create node at the end
    last_node.next.item = item;             // insert item
    }
    this.sizeM++;}                          // increase size
    public void push_front(int item){
    // PROMISES:
    //    Adds a node with an item to the beginning of the list, and increments
    //    sizeM
    Node new_front = new Node();
    new_front.item = item;                  // Create node and insert value
    new_front.next = this.headM;            // put new nodes's next as the head
    this.headM = new_front;                 // put the head as the new node
    this.sizeM++;                           // increase size

    }
    public void pop_back(){
    // PROMISES:
    //    The last node in the list is removed
        Node last_node = this.headM;
        while(last_node.next.next != null){     // Loop through nodes til the second last one
        last_node = last_node.next;
    }
    last_node.next = null;                      // Put second last's next node as null thus deleting the end
    }
    public int get(int n){
        if(n<0||n>=this.sizeM) {System.err.println("Illegal Access"); System.exit(0);} //Terminate program with wrong input
            int i = 0;
            Node need_node = this.headM;
            while( i != n){                     // Loop through nodes til the nth one
                need_node = need_node.next;
                i++;
            }
            return need_node.item;              // return value of the nth node
        }
    public void set(int i, int v){      
    // PROMISES:
    //    puts the value of v at the i-th position
         if(i<0||i>=this.sizeM) System.err.println("Illegal Access"); // Error if wrong input
        else{
            int j = 0;
            Node change = this.headM;
            while( j != i){                     // Loops through node till the i'th one
                change = change.next;
                j++;
            }
            change.item = v;                    // Changes the i'th item to v
        }
    }
    
    public void insert(int theItem, int n){ 
    // PROMISES:
    //    A node with a copy of theItem is inserted at the nth position, and sizeM
    //    will be incremented if the operation of insert was successfull.
    //    if n == sizeM calles push_back
    //    if n == 0 calls push_front
    //    if n < 0 or n > sizeM returns and does nothing.

        if(n<0||n>this.sizeM){}                         // Do nothing with wrong input
        else if(n==0)this.push_front(theItem);          // O calls push front
        else if(n==this.sizeM)this.push_back(theItem);  // sizeM calls push back
        else{
            int i = 0;
            Node nextnode = this.headM;                 
            Node lastnode = this.headM;
        while( i < n){                                  // Cycle through til the n'th spot
            lastnode = nextnode;
            nextnode = nextnode.next;
            i++;
    }   
        Node insertnode = new Node();                   // Create new node
        insertnode.item = theItem;                      // assign theItem
        insertnode.next = nextnode;
        lastnode.next = insertnode;                     // Insert node into n'th spot
        this.sizeM++;                                   // Increase the size
        }
    }
    public void remove(int n){
    //  PROMISES:
    //    Does nothing if n < 0 or n > sizeM-1. Otherwise, if list is not empty
    //    removes the node at the position n.
        if(n<0||n>this.sizeM-1){}                   // Does nothing with wrong input
        else if(n == 0) {this.headM = this.headM.next; this.sizeM--;}
        else{
            int i = 0;
            Node nextnode = this.headM;
            Node lastnode = this.headM;
        while( i < n){                          // Loops through nodes til n'th item
            lastnode = nextnode;
            nextnode = nextnode.next;
            i++;
    }
        lastnode.next = nextnode.next;          // Puts next pointer of (n-1) to (n+1) deleting n'th node
        this.sizeM--;                           // Decrease the size
        }
    }
    public void clear(){
    // PROMISES
    // Deallocate all nodes, and sets headM to zero, and size to zero
    this.headM = null; this.sizeM = 0;  // Puts head to null and size to 0 lets garbage collector do the work
}
    public void print()                         // Changed print to a member function
{
    Node temp = this.headM;
    if(temp == null)System.out.println("This list is empty");   //If list is empty print message
    else{
    while(temp!= null){                             // Loops through node printing each one
        System.out.println(temp.item);
        temp = temp.next;
    }}
}
}
