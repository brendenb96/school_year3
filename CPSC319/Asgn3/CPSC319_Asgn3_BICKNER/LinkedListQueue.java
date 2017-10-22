
public class LinkedListQueue {
    private SinglyLinkedList list = new SinglyLinkedList();

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Node firstEl() {
        return list.getFirst();
    }

    public Node dequeue() {
        return list.removeFirst();
    }

    public void enqueue(Node el) {
        list.addLast(el);
    }
}


