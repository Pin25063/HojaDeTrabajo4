/**
 * Interfaz compartida para definir el comportamiento de la calculadora
 * 
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
*/

public interface Calc_temp {
    /**
     * Evalúa la expresión
     * 
     * Precondición:
     * - La cadena no debe ser nula
     * 
     * Postcondición:
     * - Retorna el resultado de evaluar la operación si esta es válida
     * - Si la operación u operandos no son correctos se lanzan excepciones
     * 
     * @param input de cadena con la operación para evaluar
     * @return resultado de la operación 

     */
    public double Operate (String input);
}