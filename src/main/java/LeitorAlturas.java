
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class LeitorAlturas {

    public static double[] lerAlturas() {

        ArrayList<Double> alturas = new ArrayList<>();

        try {
            InputStream arquivo = LeitorAlturas.class
                    .getResourceAsStream("/alturas/alturas.txt");

            if (arquivo == null) {
                System.out.println("Arquivo de alturas não encontrado!");
                return new double[0];
            }

            try (Scanner scanner = new Scanner(
                    arquivo, StandardCharsets.UTF_8)) {

                while (scanner.hasNextLine()) {

                    String linha = scanner.nextLine().trim();

                    if (!linha.isEmpty()) {
                        alturas.add(Double.parseDouble(
                                linha.replace(",", ".")
                        ));
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return alturas.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
    }
}
