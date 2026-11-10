
/**
 *
 * @author migue
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LeitorAlturas {

    public static double[] lerAlturas(String caminho) {

        ArrayList<Double> alturas = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(caminho));

            while (scanner.hasNextLine()) {

                String linha = scanner.nextLine().trim();

                if (!linha.isEmpty()) {
                    alturas.add(Double.parseDouble(
                        linha.replace(",", ".")
                    ));
                }
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return alturas.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }
}