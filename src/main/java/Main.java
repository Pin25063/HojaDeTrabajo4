/**
 * Clase principal del programa
 *
 * Lee las operaciones desde un archivo datos.txt, donde cada línea representa una operación distinta
 *
 * @author Jose Pinto 25063
 * @author Valeria Hernández 25086
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        View vista = new View();

        String type = View.askCase();
        Calc calculadora = new Calculator(type);

        try (
                FileReader fileReader = new FileReader("src/main/resources/datos.txt");
                BufferedReader bufferReader = new BufferedReader(fileReader);
        ) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    try {
                        double result = calculadora.operate(line);
                        vista.showMessage(line + " = " + result);

                    } catch (Exception e) {
                        vista.showMessage(line + " Error: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            vista.showMessage("Error al leer el archivo datos.txt");
        }
    }
}