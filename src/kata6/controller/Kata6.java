package kata6.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.model.Person;
import kata6.view.DataBaseList;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

 public class Kata6 {
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private static HistogramDisplay histoDisplay;
    private MailHistogramBuilder<Mail> builder;
    private Histogram<String> domains;
    private Histogram<Character> letters;
    private Histogram<Character> gender;
    private  List<Person> people;
   
    public static void main(String[] args) throws IOException {
      Kata6 kata6 = new Kata6();
      kata6.execute();
    }
    
    private void execute() throws IOException {
        input();
        process();
        output();
    }
    
    private void input() throws IOException {
        String fileName="emailsfile.txt";
        mailList= MailListReader.read(fileName);
        builder = new MailHistogramBuilder<Mail>(mailList);
    }
    
    private void process() throws ClassNotFoundException, SQLException{
        domains = builder.build(new Attribute<Mail, String>() {
        
        @Override
        public String get(Mail item) {
            return item.getMail().split("@")[1];
        }
    });
        
    letters = builder.build(new Attribute<Mail, Character>() {
        
        @Override
        public Character get(Mail item) {
            return item.getMail().charAt(0);
        }
    });
    
    people = DataBaseList.read();
    MailHistogramBuilder<Person> builderPerson = new MailHistogramBuilder<>(people);
    gender = builderPerson.build(new Attribute<Person,Character>() {
        
        @Override
        public Character get(Person item) {
            return item.getGender();
        }
    });
    
    
    private void output() {
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay (letters,"Primer Caracter").execute();
        new HistogramDisplay (gender,"Gender").execute();
        histoDisplay.execute();
    }
}

