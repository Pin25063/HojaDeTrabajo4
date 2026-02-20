/**
 * Clase de pruebas unitarias con JUnit para comprobar el funcionamiento de los stacks y de la calculadora
 *
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class JUnitTests {

    Stack<Double> stack;
    Calc calculadora;

    @Before
    public void setup(){
        stack = new StackO<>();
        calculadora = new Calculator();
    }

    @Test
    public void isLastElementFive(){
        stack.push(4.0);
        stack.push(5.0);
        assertEquals(5 , stack.peek(), 0.0);
    }

    @Test
    public void isDeletedElementNine(){
        stack.push(4.0);
        stack.push(5.0);
        stack.push(9.0);
        double x = stack.pop();
        assertEquals(9 , x, 0.0);
    }

    @Test
    public void isFinalResultFifteen(){
        double result = calculadora.operate("1 2 + 4 * 3 +");
        assertEquals(15, result, 0.0);
    }

    @Test
    public void popOnEmptyStackReturnsNull() {
        assertEquals(null, stack.pop());
    }

    @Test
    public void peekOnEmptyStackReturnsNull() {
        assertEquals(null, stack.peek());
    }

    @Test (expected = ArithmeticException.class)
    public void divisionByZeroThrowsException() {
        calculadora.operate("6 0 /");
    }

    @Test(expected = IllegalArgumentException.class)
    public void insufficientOperandsThrowException() {
        calculadora.operate("1 +");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidOperatorThrowsException() {
        calculadora.operate("1 2 x");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidPostfixExpressionThrowsException() {
        calculadora.operate("1 2 3 +");
    }
}
