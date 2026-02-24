/**
 * Implementación Stack utilizando listas
 *
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

public class StackL<T> extends AbstractStack<T> {
    private List<T> list;

    public StackL(List<T> list) {
        this.list = list;
    }

    @Override
    public void push(T item) {
        list.add(item);
    }

    @Override
    public T pop() {
        return list.remove();
    }

    @Override
    public T peek() {
        return list.get();
    }
}
