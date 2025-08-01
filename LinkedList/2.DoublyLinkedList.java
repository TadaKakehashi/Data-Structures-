public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    DoublyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    class Node {
        private int data;
        private Node next;
        private Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Appending
    public void AppendNode(int data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    // Prepending
    public void prependNode(int data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        length++;
    }

    // Removing Last
    public Node removeLast() {
        if (length == 0) {
            System.out.println("Empty List!");
            return null;
        }
        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
            return temp;
        } else {
            tail = temp.prev;
            tail.next = null;
            temp.prev = null;
        }

        length--;
        return temp;
    }

    // Removing First
    public Node removeFirst() {
        if (length == 0) {
            System.out.println("Empty List!");
            return null;
        }
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
            return temp;
        } else {
            head = head.next;
            temp.next = null;
            head.prev = null;
        }
        length--;
        return temp;
    }

    // Remove node at specific index
    public Node removeAt(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid Index");
            return null;
        }

        if (index == 0)
            return removeFirst();
        if (index == length - 1)
            return removeLast();

        Node temp = get(index);
        Node before = temp.prev;
        Node after = temp.next;

        before.next = after;
        after.prev = before;

        temp.next = null;
        temp.prev = null;
        length--;

        return temp;
    }

    // Get Method
    public Node get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid Index");
            return null;
        }
        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < length; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    // Set Method
    public boolean set(int index, int data) {
        Node temp = get(index);
        if (temp != null) {
            temp.data = data;
            return true;
        }
        return false;
    }

    // InsertAt Method
    public boolean insertAt(int index, int data) {
        if (index < 0 || index > length) {
            System.out.println("Invalid  Index");
            return false;
        }
        if (index == 0) {
            prependNode(data);
            return true;
        }
        if (index == length) {
            AppendNode(data);
            return true;
        }
        Node newNode = new Node(data);
        Node before = get(index - 1);
        if (before == null) {
            return false;
        }
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        if (after != null) {
            after.prev = newNode;
        }
        length++;
        return true;
    }

    // Printing Methods
    public void printList() {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                System.out.print(temp.data + " --> NULL ");
            } else {
                System.out.print(temp.data + " <---> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void printLength() {
        System.out.println("Length of the List: " + length);
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.AppendNode(10);
        list.AppendNode(20);
        list.AppendNode(30);
        list.AppendNode(40);
        list.AppendNode(50);
        list.printList();
        list.printLength();

        // Prepending Nodes
        list.prependNode(100);
        list.printList();
        list.printLength();

        // Removing Last
        System.out.println("Last Node of the List: " + list.removeLast().data);
        list.printList();
        list.printLength();

        // Removing First
        System.out.println("First Node of the List: " + list.removeFirst().data);
        list.printList();
        list.printLength();

        // Getting Implementation:
        System.out.println("Getting Node data of index 2: " + list.get(2).data);
        list.printList();
        list.printLength();

        // Set value at index 4 to 100
        list.set(4, 100);
        System.out.println("After setting index 4 to 100:");
        list.printList();
        list.printLength();

        // Insert at index 2
        list.insertAt(2, 25);
        System.out.println("After inserting 25 at index 2:");
        list.printList();
        list.printLength();

        // Removing at
        System.out.println("Removing node at index 2: " + list.removeAt(2).data);
        list.printList();
        list.printLength();
    }
}
