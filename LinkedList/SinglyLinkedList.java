public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void appendNode(int data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prependNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (head == null) {
            System.out.println("Empty list");
            return null;
        }
        Node temp = head;
        Node prev = head;
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return temp;
        }
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        length--;
        return temp;
    }

    public Node removeFirst() {
        if (head == null) {
            System.out.println("Empty List");
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid Index");
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int data) {
        Node temp = get(index);
        if (temp != null) {
            temp.data = data;
            System.out.println("Data changed");
            return true;
        }
        return false;
    }

    public boolean insertAt(int index, int data) {
        if (index < 0 || index > length) {
            System.out.println("Invalid Index");
            return false;
        }
        if (index == 0) {
            prependNode(data);
            return true;
        }
        if (index == length) {
            appendNode(data);
            return true;
        }

        Node newNode = new Node(data);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node removeAt(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid Index");
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.data + " -> ");
        temp = temp.next;
    }
    System.out.println("null");
    System.out.println();
}


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("Appending nodes:");
        list.appendNode(10);
        list.appendNode(20);
        list.appendNode(30);
        list.printList();

        System.out.println("Prepending nodes:");
        list.prependNode(5);
        list.prependNode(1);
        list.printList();

        System.out.println("Get node at index 2:");
        Node nodeAt2 = list.get(2);
        if (nodeAt2 != null)
            System.out.println("Data at index 2: " + nodeAt2.data);
            System.out.println();

        System.out.println("Set value at index 3 to 99:");
        list.set(3, 99);
        list.printList();

        System.out.println("Insert node at index 2 (value 15):");
        list.insertAt(2, 15);
        list.printList();

        System.out.println("Remove node at index 4:");
        Node removed = list.removeAt(4);
        if (removed != null)
            System.out.println("Removed: " + removed.data);
        list.printList();

        System.out.println("Removing first and last:");
        Node first = list.removeFirst();
        Node last = list.removeLast();
        if (first != null)
            System.out.println("First removed: " + first.data);
        if (last != null)
            System.out.println("Last removed: " + last.data);
        list.printList();
        list.getLength();
    }
}
