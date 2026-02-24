/**
 * Clase de pruebas unitarias con JUnit para comprobar el funcionamiento de los stacks y de la calculadora
 *
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class JUnitTests {

    Stack<Double> stack;
    Calc calculadora;

    @Before
    public void setup() {
        StackFactory factory = new StackFactory();
        stack = factory.generateStack("vector", null);
        calculadora = Calculator.getInstance("vector", null);
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
        assertNull(stack.pop());
    }

    @Test
    public void peekOnEmptyStackReturnsNull() {
        assertNull(stack.peek());
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
    public void invalidOperatorThrowsException() { calculadora.operate("1 2 x"); }

    @Test(expected = IllegalArgumentException.class)
    public void invalidPostfixExpressionThrowsException() { calculadora.operate("1 2 3 +"); }

    @Test
    public void factoryCreatesStackListSimple() {
        StackFactory factory = new StackFactory();
        AbstractStack<Double> stack = factory.generateStack("lista", "simple");
        assertEquals(StackL.class, stack.getClass());
    }

    @Test
    public void factoryCreatesStackListDouble() {
        StackFactory factory = new StackFactory();
        AbstractStack<Double> stack = factory.generateStack("lista", "doble");
        assertEquals(StackL.class, stack.getClass());
    }

    @Test
    public void factoryInvalidTypeReturnsNull() {
        StackFactory factory = new StackFactory();
        AbstractStack<Double> stack = factory.generateStack("invalido", null);
        assertNull(stack);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyExpressionThrowsException() {
        Calc calc = Calculator.getInstance("vector", null);
        calc.operate("");
    }

    @Test
    public void stackSimpleListBehavesAsLIFO() {
        StackFactory factory = new StackFactory();
        Stack<Double> s = factory.generateStack("lista", "simple");
        s.push(1.0);
        s.push(2.0);
        s.push(3.0);
        assertEquals(3.0, s.pop(), 0.0);
    }

    @Test
    public void stackDobleListBehavesAsLIFO() {
        StackFactory factory = new StackFactory();
        Stack<Double> s = factory.generateStack("lista", "doble");
        s.push(1.0);
        s.push(2.0);
        s.push(3.0);
        assertEquals(3.0, s.pop(), 0.0);
    }
}
