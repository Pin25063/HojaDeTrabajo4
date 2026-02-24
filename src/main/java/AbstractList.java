/**
 * Clase abstracta para Listas
 *
 * Esta clase sirve como base para las implementaciones de listas
 * simple y doblemente encadenadas
 *
 * @param <T> Tipo de dato genérico almacenado en la lista
 *
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

public abstract class AbstractList<T> implements List<T> {
    public abstract void add(T element);
    public abstract T remove();
    public abstract T get();
}
