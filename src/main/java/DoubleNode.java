/**
 * Implementación de nodo para lista doblemente encadenada
 *
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

public class DoubleNode<T> {
    T value;
    DoubleNode<T> next;
    DoubleNode<T> previous;

    public DoubleNode(T value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }

    public T getValue() {
        return value;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}
