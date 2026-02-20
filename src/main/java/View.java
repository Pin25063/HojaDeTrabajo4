/**
* @author Jose Pinto 25063
* @author Valeria Hernández 25086
*/

import java.util.Scanner;

public class View {
    
    public Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
