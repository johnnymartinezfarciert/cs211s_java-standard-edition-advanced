import java.util.*;

public class LeakyStack<T> {

    private T[] elements;
    private int size;

    public LeakyStack(int initialCapacity) {
        elements = (T[]) new Object[initialCapacity];
        size=0;
    }

    public void push(T element) {
        ensureCapacity();
        elements[size] = element;
        size++;
    }

    public T pop() {
        if (size == 0)
            throw new EmptyStackException();
        T returnValue = elements[size-1]; // memory leak!
        //elements[size-1]=null; // memory leak fixed!
        size--;
        return returnValue;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
