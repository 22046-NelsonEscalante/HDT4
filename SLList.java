public class SLList<T> extends AbstractList<T> {

    private int count;
    private Node<T> start;
    private Node<T> end;


    @Override
    public int size() {
        return count;
    }

    @Override
    public void add(T value) {
        count++;
        Node<T> newNode = new Node<T>(value, null);
        if (this.start != null) {
            newNode.setNext(start);
        }
        this.start = newNode;
        if (this.end == null) {
            this.end = newNode;
        }
    }

    @Override
    public T get() {
        if (!isEmpty()) {
            count--;
            Node<T> temp = start;
            T val = temp.value();
            while (temp.next() != null) {
                Node<T> nextTemp = temp.next();
                temp = nextTemp;
                val = temp.value();
            }
            return val;
        } else {
            return null;
        }
    }
    
}
