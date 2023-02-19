public class DLNode<T> {
    
    protected T data;
    protected DLNode<T> nextNode;
    protected DLNode<T> prevNode;

    public DLNode(T value, DLNode<T> next, DLNode<T> prev) {
        setValue(value);
        setNext(next);
        setPrev(prev);
    }

    public DLNode<T> next() {
        return nextNode;
    }

    public DLNode<T> prev() {
        return prevNode;
    }

    public T value() {
        return data;
    }

    public void setValue(T value) {
        this.data = value;
    }

    public void setNext(DLNode<T> next) {
        this.nextNode = next;
    }

    public void setPrev(DLNode<T> prev) {
        this.prevNode = prev;
    }
}
