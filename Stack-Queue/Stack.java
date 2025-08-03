package Stack;

import java.util.EmptyStackException;

public class Stack {
    private Node top;
    private int height;

    Stack(){
        this.top = null;
        this.height = 0;
    }

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public void push(int data){
        Node newNode = new Node(data);
        if(height == 0){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        if(height == 0){
            return null;
        }
        Node temp = top;
        top = temp.next;
        temp.next = null;
        height--;
        return temp;
    }

    public int peek(){
        if(top == null){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void printStack(){
        Node temp = top;
        while(temp != null){
            System.out.println("|"+temp.data+"|");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.printStack();
        stack.pop();
        System.out.println();
        stack.printStack();
        System.out.println("Peeking from the top:->"+stack.peek());
    }
}
