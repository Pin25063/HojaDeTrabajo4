/**
 * Implementación de una calculadora para expreciones postfix

 * 
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

public class Calculator implements Calc{
    /**
     * Evalúa la expresión
     * 
     * Precondición:
     * - La cadena de entrada no debe ser nula
     * - Los operandos y operadores deben de estar separados por un espacio
     * 
     * Postcondición:
     * - Retorna el resultado de evaluar la operación
     * - La pila se vacía al finalizar cada operación 
     * 
     * @param input de cadena con la operación para evaluar
     * @return resultado de la operación 
     * @throws IllegalArgumentException si el operador es inválido o no hay suficientes operandos
     * @throws ArithmeticException si se intenta dividir entre cero
     */
    @Override
    public double operate (String input){
        
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("La entrada no puede estar vacía");
        }

        Stack<Double> stack = new StackO<>();
        //PilaArrayList<Double> stack = new StackA<>();
        String[] expression = input.split(" ");

        for (int i = 0; i < expression.length; i++){
            String token = expression[i];
            try {
                // Si es número
                double number = Double.parseDouble(token);
                stack.push(number);
            } catch (NumberFormatException e) {
                
                double a, b;

                try {
                    b = stack.pop();
                    a = stack.pop();
                } catch (Exception p) {
                    throw new IllegalArgumentException("No hay operandos suficientes");
                }

                switch (token) {
                case "+":
                    stack.push(a + b);
                    break;
                case "-":
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(a * b);
                    break;
                case "/":
                    if (b == 0) {
                        throw new ArithmeticException("División entre cero");
                    }
                    stack.push(a / b);
                    break;
                default:
                    throw new IllegalArgumentException("Operador inválido");
                }
            }
        }
        
        double result;
        try {
            result = stack.pop(); //verifica que haya un resultado
        } catch (Exception c) { 
            throw new IllegalArgumentException("Operación inválida");
        }

        try {
            stack.pop(); //verifica que no sobre ningun operando
            throw new IllegalArgumentException("Operación inválida");
        } catch (Exception x) {
        }
            
        return result;
    }
}
