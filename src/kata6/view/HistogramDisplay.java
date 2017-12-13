package kata6.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import kata6.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 * class HistogramDisplay - kata6_v1
 * 
 * @author karansainani
 */

public class HistogramDisplay <T> extends ApplicationFrame {
    
    private final Histogram<T> histogram;
    private final String name_Eje;
    
    public HistogramDisplay(Histogram<T> histogram, String name_Eje) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
        this.name_Eje = name_Eje;
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Histograma JFreeChart",
                "Dominios email", 
                "Nº de emails", 
                dataSet, 
                PlotOrientation.VERTICAL, 
                rootPaneCheckingEnabled, 
                rootPaneCheckingEnabled, 
                rootPaneCheckingEnabled);
        return chart;
        
    }
    
   private DefaultCategoryDataset createDataset() {
       DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
           dataSet.addValue( histogram.get(key), "", (Comparable) key);
        }
       return dataSet;
   }
    
    public void execute() {
        setVisible(true);
    }
    
}
 

