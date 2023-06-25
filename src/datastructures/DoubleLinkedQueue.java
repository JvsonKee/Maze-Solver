package datastructures;

import exceptions.UnderflowException;

public class DoubleLinkedQueue <T> implements DoubleLinkedQueueInterface<T> {

    private DNode<T> front, rear;
    private int size;

    public DoubleLinkedQueue()
    {
        rear = null;
        front = null;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public boolean isFull() {
        return false;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        DNode<T> newNode = new DNode<T>();
        newNode.setValue(item);
        if (isEmpty()) {
            front = rear = newNode;
            front.setNext(rear);
            rear.setPrev(front);
        } else {
            newNode.setNext(rear);
            rear.setPrev(newNode);
            rear = newNode;
        }    
        rear.setPrev(front);
        front.setNext(rear);   
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new UnderflowException("Queue is empty");
        }
        DNode<T> temp = front;
        if (front == rear) {
            front = null;
            rear = null;
            return temp.getValue();
        } 
        
        front.getPrev().setNext(rear);
        front = front.getPrev();
        rear.setPrev(front);
        return temp.getValue();
    }
    
    public DNode<T> prev() {
        front = front.getPrev();
        return front;
    }

    public void printQueue() {
        System.out.print("r->");
        DNode<T> i = rear;
        if (front == rear && front != null) System.out.print(i.getValue());
        else 
            while (i != null && i.getNext() != rear) {
                System.out.print(i.getValue());
                if (i.getNext() != null) System.out.print(",");
                i = i.getNext();
            }
        if (front != rear) {
            System.out.print(i.getValue());
        }
        System.out.println("<-f");
    }
}
