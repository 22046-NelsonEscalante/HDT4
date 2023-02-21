public class DLList<T> extends AbstractList<T> {

    protected int count;
    protected DLNode<T> start;
    protected DLNode<T> end;

    public DLList() {
        count = 0;
        start = null;
        end = null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void add(T value) {
        count++;
        DLNode<T> newNode = new DLNode<T>(value);
        if (isEmpty()) {
            start = newNode;
            end = newNode;
            start.setNext(start);
            start.setPrev(start);
        } else {
            newNode.setNext(start);
            start.setPrev(newNode);
            newNode.setPrev(end);
            end.setNext(newNode);
            start = newNode;
        }
    }

    @Override
    public T get(int index) {
        DLNode<T> temp = end;
        end = end.prevNode;
        if (end == null) {
            start = null;
        } else {
            end.setNext(null);
        }
        count--;
        return temp.value();
    }

    @Override
    public T delete(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public T deleteAtStart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAtStart'");
    }

    @Override
    public T deleteAtEnd() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAtEnd'");
    }
    
}
