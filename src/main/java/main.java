/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */


import java.awt.Color;
import org.jfree.chart.ChartFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;
import javax.swing.JFrame;


public class main {

    public static void main(String[] args) {

      String caminho = System.getProperty("user.dir") 
        + "/src/alturas/alturas.txt";
       double[] alturas = LeitorAlturas.lerAlturas();

        if (alturas.length == 0) {
            System.out.println("Nenhuma altura encontrada!");
            return;
        }



        double soma = 0;

        for (int i = 0; i < alturas.length; i++) {
        soma += alturas[i];
         }

        double media = soma / alturas.length;
        
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
        janela.setLayout(new BorderLayout());
        janela.getContentPane().setBackground(Color.BLACK);
        // Gráfico no centro
        ChartPanel painel = new ChartPanel(grafico);
        painel.setBackground(Color.BLACK);

        janela.add(painel, BorderLayout.CENTER);

       
        JLabel textoMedia = new JLabel(
    String.format("Média: %.2f metros", media),
    SwingConstants.CENTER
    );

        textoMedia.setOpaque(true);
        textoMedia.setBackground(Color.BLACK);
        textoMedia.setForeground(Color.WHITE);

        janela.add(textoMedia, BorderLayout.SOUTH);

        janela.add(textoMedia, BorderLayout.SOUTH);

        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        textoMedia.setOpaque(true);
        grafico.setBackgroundPaint(Color.BLACK);
        grafico.getPlot().setBackgroundPaint(Color.BLACK);
        
    }
}
