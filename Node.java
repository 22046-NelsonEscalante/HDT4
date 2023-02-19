public class Node<T> {
    
    protected T data;
    protected Node<T> nextNode;

    public Node(T value, Node<T> nextNode) {
        setValue(value);
        setNext(nextNode);
    }

    public Node<T> next() {
        return nextNode;
    }

    public T value() {
        return data;
    }

    public void setValue(T value) {
        this.data = value;
    }

    public void setNext(Node<T> next) {
        this.nextNode = next;
    }
}
