/**
* @author Jose Pinto 25063
* @author Valeria Hernández 25086
*/

import java.util.Scanner;

public class View {
    
    public static Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public static String askCase(){
        System.out.println("Ingresse el tipo de Stack que desea utilizar (vector/lista):");
        return scanner.nextLine();
    }
}
