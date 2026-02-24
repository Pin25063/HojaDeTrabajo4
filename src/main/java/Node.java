/**
 * Implementación de nodo para lista simplemente encadenada
 *
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */


public class Node<T> {
    private T value;
    private Node<T> next;

    public Node (T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }
    
    public void setNext(Node<T> next) {
        this.next = next;
    }
}