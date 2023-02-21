public class StackSLList<T> extends AbstractStack<T> {
    
    protected SLList<T> myList;

    public StackSLList() {
        myList = new SLList<>();
    }

    @Override
    public int count() {
        return myList.size();
    }

    @Override
    public boolean isEmpty() {
        return myList.isEmpty();
    }

    @Override
    public void push(T value) {
        myList.add(value);
    }

    @Override
    public T pull() {
        return myList.delete(0);
    }

    @Override
    public T peek() {
        return myList.get(0);
    }

}
