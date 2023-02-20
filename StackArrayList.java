import java.util.ArrayList;

public class StackArrayList<T> extends AbstractStack<T> {

    protected ArrayList<T> myArray;

    public StackArrayList() {
        myArray = new ArrayList<T>();
    }

    @Override
    public int count() {
        return myArray.size();
    }

    @Override
    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    @Override
    public void push(T value) {
        myArray.add(0, value);
    }

    @Override
    public T pull() {
        return myArray.remove(0);
    }

    @Override
    public T peek() {
        return myArray.get(0);
    }
    
}
