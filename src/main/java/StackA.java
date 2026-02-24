/**
 * Implementación de una pila genérica usando ArrayList
 * 
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
*/

import java.util.ArrayList;

public class StackA<T> extends AbstractStack<T>{
    
    ArrayList<T> stack;

    public StackA() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()){
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (stack.isEmpty()){
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}