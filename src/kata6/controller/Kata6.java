package kata6.controller;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

 public class Kata6 {
    private List<Mail> mailList;
    private Histogram<String> histogram;
   
    public static void main(String[] args) throws IOException {
      Kata6 kata6 = new Kata6();
      kata6.execute();
    }
    
    void execute() throws IOException {
        input();
        process();
        output();
    }
    
    void input() throws IOException {
        String fileName="emailsfile.txt";
        mailList= MailListReader.read(fileName);
    }
    
    void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}

