/**
 * Implementación de lista doblemente encadenada
 *
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

public class DoubleLinkedList<T> extends AbstractList<T> {
    private DoubleNode<T> first;

    public DoubleLinkedList() {
        this.first = null;
    }

    @Override
    public void add(T value) {
        if (first == null) {
            first = new DoubleNode<T>(value);
        } else {
            var current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }

            DoubleNode<T> newNode = new DoubleNode<T>(value);
            current.setNext(newNode);
            newNode.setPrevious(current);
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

        DoubleNode<T> current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        T value = current.getValue();
        DoubleNode<T> previous = current.getPrevious();
        previous.setNext(null);
        return value;
    }

    @Override
    public T get() {
        if (first == null) {
            return null;
        }
        
        DoubleNode<T> current = first;
        while (current.getNext() != null) {
            current  = current.getNext();
        }

        return current.getValue();
    }
}
