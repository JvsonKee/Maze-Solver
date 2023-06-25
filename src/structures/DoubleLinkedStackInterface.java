package structures;

public interface DoubleLinkedStackInterface <T> {
     public boolean isEmpty();

    public boolean isFull();

    public void push (T element);

    public T pop();

    public T peek();
}
