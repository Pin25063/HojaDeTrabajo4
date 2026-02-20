/**
 * Implementación de una pila genérica usando Vector
 * 
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
*/

import java.util.Vector;

public class StackO<T> implements Stack<T> { 
    
    Vector<T> stack; 

    public StackO(){
        this.stack = new Vector<>();
    }

    public void push(T item) { 
        stack.add(item);
    }

    public T pop() { 
        if (stack.isEmpty()) return null; 
        return stack.remove(stack.size() - 1);
    }

    public T peek() { 
        if (stack.isEmpty()) return null; 
        return stack.lastElement();
    }    
}