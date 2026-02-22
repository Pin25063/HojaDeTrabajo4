public abstract class AbstractStack<T> implements Stack<T> {
    public abstract void push(T item);
    public abstract T pop();
    public abstract T peek();
}