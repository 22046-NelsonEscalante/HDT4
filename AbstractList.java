public abstract class AbstractList<T> implements IList<T> {
    
    public AbstractList() {}

    public boolean isEmpty() {
        return size() == 0;
    }
}
