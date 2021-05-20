import java.util.ArrayList;
import java.util.Arrays;

public class Deque<E>
{
    private ArrayList<E> deque;
    private int size;

    public Deque()
    {
        this.deque = new ArrayList<>();
        this.size = 0;
    }

    public boolean isEmpty()
    {
        return this.size == 0;
    }

    public void pushLast(E element)
    {
        this.deque.add(element);
        this.size++;
    }

    public void pushFirst(E element)
    {
        this.deque.add(0, element);
        this.size++;
    }

    public E peekLast()
    {
        if(size != 0)
        {
            return this.deque.get(this.size-1);
        }
        System.out.println("Deque is empty");
        return null;
    }

    public E peekFirst()
    {
        if(size != 0)
        {
            return this.deque.get(0);
        }
        System.out.println("Deque is empty");
        return null;
    }

    public E popLast()
    {
        if(size != 0)
        {
            E element = this.deque.get(this.size-1);
            this.deque.remove(this.size-1);
            this.size--;
            return element;
        }
        System.out.println("Deque is empty");
        return null;
    }

    public E popFirst()
    {
        if(size != 0)
        {
            E element = this.deque.get(0);
            this.deque.remove(0);
            this.size--;
            return element;
        }
        System.out.println("Deque is empty");
        return null;
    }

    public String toString()
    {
        return Arrays.toString(this.deque.toArray());
    }

    public int getSize()
    {
        return this.size;
    }
}