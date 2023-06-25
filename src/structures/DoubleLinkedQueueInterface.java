package structures;

public interface DoubleLinkedQueueInterface<T> {
    public boolean isEmpty();

    public boolean isFull();

    public int size();

    public void enqueue (T element);
    
    public T dequeue();
}
