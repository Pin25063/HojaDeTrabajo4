import java.util.ArrayList;

/**
 * Implementación de una calculadora para expreciones postfix
 *
 * Permite convertir expresiones infix a postfix para su evaluación
 * y evalua el orden de precedencia de los operandos
 *
 * Precondiciones:
 * - Los operandos deben de ser numeros válidos
 * - Las operaciones deben de usar operandos soportados
 *
 * Postcondiciones:
 * - Las operaciones dejan la pila vacía después de evaluarse
 * - Los métodos retornan el resultado de la operación o la operación transformada correctamente
 * 
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

public class Calculator implements Calc{
    private static Calculator instance = null;
    private String stackType;
    private String listType;
    private AbstractStack<Double> stack;

    private Calculator(String stackType, String listType){
        this.stackType = stackType;
        this.listType = listType;

        StackFactory factory = new StackFactory();
        stack = factory.generateStack(stackType, listType);

        if (stack == null) {
            throw new IllegalArgumentException("Tipo de stack o lista inválido");
        }
    }

    public static Calculator getInstance(String stackType, String listType){
        if (instance == null) {
            instance     = new Calculator(stackType, listType);
        }
        return instance;
    }
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
        StackFactory factory = new StackFactory();
        AbstractStack<Double> stack = factory.generateStack(stackType, listType);

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("La entrada no puede estar vacía");
        }

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
        
        Double result = stack.pop();
        if (result == null) {
            throw new IllegalArgumentException("Operación inválida");
        }

        if(stack.pop() != null) { //verifica que no hayan operandos extra
            throw new IllegalArgumentException("Operación inválida");
        }
            
        return result;
    }

    /**
     * Convierte una expresión de notación infix a postfix
     *
     * Precondiciones:
     * - input no debe ser null ni vacío.
     * - Los operandos deben ser números enteros simples.
     * - Los operadores soportados son +, -, *, / y ^.
     *
     * Postcondiciones:
     * - Retorna la expresión en formato postfix
     */
    public String infixToPostfix(String input) {
        StackFactory factory = new StackFactory();
        StackA<String> stack = new StackA<>();

        input = input.replace(" ", "");
        String[] infix = input.split("");
        ArrayList<String> out = new ArrayList();

        stack.push("#");
        for (String token : infix) {
            try {
                int number = Integer.parseInt(token);
                out.add(String.valueOf(number));
            } catch (NumberFormatException e) {
                if (token.equals("(")) {
                    stack.push("(");
                } else if (token.equals(")")) {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        out.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                        out.add(stack.pop());
                    }
                    stack.push(token);
                }
            }
        }
        while (!stack.isEmpty()){
            String top = stack.pop();
            if (!top.equals("#") && !top.equals("(")) {
                out.add(top);
            }
        }
        return String.join(" ", out);
    }

    /**
     * Devuelve la precedencia de un operador.
     * @param op operador (+, -, *, /, ^)
     * @return valor de precedencia (mayor número = mayor precedencia)
     */
    public static int precedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> 0;
        };
    }
}
