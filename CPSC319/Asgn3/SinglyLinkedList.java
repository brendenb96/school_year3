
//To implement a singly linked list and necessary methods for insertion, removal and traversal
public class SinglyLinkedList {
    
    public Node head,tail;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public void clear(){
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty(){
        return this.head == null;
    }
    public Node getFirst(){
        return this.head;
    }
    public void addLast(Node newNode) {
        if (newNode == null)
            return;
        else {
            newNode.next = null;
            if (head == null) {
                head = newNode;
                tail = newNode;
            } 
            else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }
    
    public void addFirst(Node newNode) {
        if (newNode == null)
            return;
        else {
            if (head == null) {
                newNode.next = null;
                head = newNode;
                tail = newNode;
            } 
            else {
                newNode.next = head;
                head = newNode;
            }
        }
    }

    public void insertAfter(Node previous, Node newNode) {
        if (newNode == null)
            return;
        else { 
            if (previous == null)
                addFirst(newNode);
            else if (previous == tail)
                addLast(newNode);
            else {
                Node next = previous.next;
                previous.next = newNode;
                newNode.next = next;
            }
        }
    }
        
    public Node removeFirst() {
        if (head == null)
            return null;
        else {
            Node temp = head;
            if (head == tail) {
                head = null;
                tail = null;
            } 
            else {
                head = head.next;
            }
            return temp;
        }
    }

    public Node removeLast() {
        if (tail == null)
            return null;
        else {
            Node temp = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } 
            else {
                Node previousToTail = head;
                while (previousToTail.next != tail)
                    previousToTail = previousToTail.next;
                tail = previousToTail;
                tail.next = null;
            }
            return temp;
        }
    }

    public void removeNext(Node previous) {
        if (previous == null)
            removeFirst();
        else if (previous.next == tail) {
            tail = previous;
            tail.next = null;
        } 
        else if (previous == tail)
            return;
        else {
            previous.next = previous.next.next;
        }
    }
    
    //an utility function to print the list
    public void printList(){
    	Node current = head;
    	while (current != null) {
    		System.out.print(current.element);	
    		System.out.print("\t");
            current = current.next;
        }
        System.out.println();
    }

    //linear search of a linked list
    public int searchList(String key){

    	Node current = head;
    	int pos = 1;

    	while (current != null) {
    		if(current.element==key)
    			return pos;
    		current = current.next;
    		pos=pos+1;
        }
        return 0;
    }

}