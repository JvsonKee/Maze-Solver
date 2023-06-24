package DataStructures;

import Exceptions.UnderflowException;

public class DoubleLinkedStack <T> implements DoubleLinkedStackInterface<T> {

 private DNode<T> top;

    public DoubleLinkedStack() {
        top = null;
    }


    public boolean isEmpty() {
        return (top == null);
    }

    public boolean isFull() {
        return false;
    }

    public void push(T item) {
        DNode<T> newNode = new DNode<T>();
        newNode.setValue(item);
        if (isEmpty()) {
            newNode.setPrev(null);
            newNode.setNext(null);
            top = newNode;
        } else {
            newNode.setNext(top);
            top.setPrev(newNode);
            top = newNode;
        }
    }

    public T pop() {
        if(isEmpty()) {
            throw new UnderflowException("Stack is empty");
        }
        DNode<T> temp = top;
        if (top.getNext() == null && top.getPrev() == null) {
            top = null;
            return temp.getValue();
        }
        top = temp.getNext();
        top.setPrev(null);
        return temp.getValue();
    }

    public T peek() {
        if (isEmpty()) {
            throw new UnderflowException("Stack is empty");
        }
        return top.getValue();
    }

    public void printStack() {
        System.out.print("top-> ");
        DNode<T> tmp = top;
       
        while (tmp != null) {
            System.out.print(tmp.getValue());
            if (tmp.getNext() != null) System.out.print(", ");
            tmp = tmp.getNext();
        }
       System.out.println();
    }
}
