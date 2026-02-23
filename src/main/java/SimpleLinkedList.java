public class SimpleLinkedList<T> extends AbstractList<T> {
    private Node<T> first;
    
    public SimpleLinkedList() {
        this.first = null;
    }

    @Override
    public void add(T value) {
        if (first == null) {
            first = new Node<T>(value);
        } else {
            var current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<T>(value));
        } 
    }

    @Override
    public T remove() {
        if (first == null) {
            return null;
        }

        if (first.getNext() == null) {
            T value = first.getValue();
            first = null;
            return value;
        }

        Node<T> current = first;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        T value = current.getNext().getValue();
        current.setNext(null);
        return value;
    }

    @Override
    public T get() {
        if (first == null) {
            return null;
        }

        Node<T> current = first;
        while(current.getNext() != null) {
            current = current.getNext();
        } 
        return current.getValue();
    }
}