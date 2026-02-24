/**
 * Clase abstracta para Listas
 *
 * Esta clase sirve como base para las implementaciones de Stacks
 * con lsitas, arraylists y vectores
 *
 * @param <T> Tipo de dato genérico almacenado en la lista
 *
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

public abstract class AbstractStack<T> implements Stack<T> {
    public abstract void push(T item);
    public abstract T pop();
    public abstract T peek();
}