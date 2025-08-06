package LinkedList;

public class LL1 {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
        }
    }

    public void appendNode(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeHead(){
        if(length == 0){
            System.out.println("Empty List!");
            return null;
        }
        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data +" -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }


    public static void main(String[] args) {
        LL1 list = new LL1();
        list.appendNode(10);
        list.appendNode(20);
        list.appendNode(30);
        list.appendNode(40);
        list.appendNode(50);
        list.printList();
        System.out.println(list.removeHead().data);
        list.printList();
    }
}
