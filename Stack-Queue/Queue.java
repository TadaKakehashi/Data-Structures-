package Queue;

public class queue {
    private Node first;
    private Node last;
    private int length;

    queue(){
        first = null;
        last = null;
        length = 0;
    }

    class Node{
        private Node next;
        private int data;
        Node(int data){
            this.data = data;
        }
    }

    public void enqueue(int data){
        Node newNode = new Node(data);
        if(length == 0){
            first = newNode;
            last = newNode;
        }
        else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if(length == 0){
            return null;
        }
        Node temp = first;
        if(length == 1){
            first = null;
            last = null;
        }
        else{
            first = temp.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public void printQueue(){
        Node temp = first;
        System.out.print("Front ->");
        while(temp != null){
            System.out.print("|" +temp.data+ "|");
            temp = temp.next;
        }
        System.out.println("<- Rear");
    }
    public static void main(String[] args) {
        queue queue = new queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.printQueue();
        System.out.println("Dequeuing");
        queue.dequeue();
        queue.printQueue();
    }
}

