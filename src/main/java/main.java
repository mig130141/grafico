
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.HistogramDataset;

public class main {

    public static void main(String[] args) {


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


        grafico.setBackgroundPaint(Color.BLACK);
        grafico.getTitle().setPaint(Color.WHITE);
        grafico.getPlot().setBackgroundPaint(Color.BLACK);
        grafico.getXYPlot().getDomainAxis().setLabelPaint(Color.WHITE);
        grafico.getXYPlot().getRangeAxis().setLabelPaint(Color.WHITE);
        grafico.getXYPlot().getDomainAxis().setTickLabelPaint(Color.WHITE);
        grafico.getXYPlot().getRangeAxis().setTickLabelPaint(Color.WHITE);

 
        JFrame janela = new JFrame("Histograma");

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());
        janela.getContentPane().setBackground(Color.BLACK);

 
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


        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }
}
