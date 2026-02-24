/**
 * Class factory para determinar que tipo de Stack se instancia
 * dependiendo del input del usuario
 *
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

public class StackFactory {

    public AbstractStack<Double> generateStack(String stackType, String listType){
        AbstractStack<Double> stack = null;

        switch(stackType.toLowerCase()) {
            case "vector":
                stack = new StackO<>();
                break;
            case "arraylist":
                stack = new StackA<>();
                break;
            case "lista":
                List<Double> list = null;
                if (listType != null) {
                    if (listType.equalsIgnoreCase("simple")) {
                        list = new SimpleLinkedList<>();
                    } else if (listType.equalsIgnoreCase("doble")) {
                        list = new DoubleLinkedList<>();
                    }
                }
                if (list != null) {
                    stack = new StackL<>(list);
                }
                break;
            default:
                stack = null;
        }

        return stack;
    }
}