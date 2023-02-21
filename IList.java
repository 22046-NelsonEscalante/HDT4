public interface IList<T> {
    
    int size();

    boolean isEmpty();

    void add(T value);

    T get(int index);

    T delete(int index);

    T deleteAtStart();

    T deleteAtEnd();
}
