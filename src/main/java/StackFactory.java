public class StackFactory {

    public AbstractStack<Double> generateStack(String type){
        return switch (type) {
            case "vector" -> new StackO<>();
            case "lista" -> new StackA<>();
            default -> null;
        };
    }
}