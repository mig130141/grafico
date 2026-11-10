/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

import javax.swing.JFrame;

public class main {

    public static void main(String[] args) {

      String caminho = System.getProperty("user.dir") 
        + "/src/alturas/alturas.txt";
        double[] alturas = LeitorAlturas.lerAlturas(caminho);

        if (alturas.length == 0) {
            System.out.println("Nenhuma altura encontrada!");
            return;
        }

        int classes = (int) Math.ceil(
            1 + 3.322 * Math.log10(alturas.length)
        );

        HistogramDataset dataset = new HistogramDataset();

        dataset.addSeries("Alturas", alturas, classes);

        JFreeChart grafico = ChartFactory.createHistogram(
            "Histograma de Alturas",
            "Altura (metros)",
            "Frequência",
            dataset
        );

        JFrame janela = new JFrame("Histograma");

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(new ChartPanel(grafico));
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);

        System.out.println("Total de alturas: " + alturas.length);
        System.out.println("Classes: " + classes);
        System.out.println("me dá ponto pls");
    }
}
