package kata6.view;

import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.controller.Attribute;


public class MailHistogramBuilder <T> {
    private final List <T> items;
    
    public MailHistogramBuilder(List<T> items) {
        this.items = items;
    }
    
    public <A>Histogram<A> build (Attribute <T,A> attribute){
           Histogram<A> histogr = new Histogram<>();
            for (T item : items) {
               A value = attribute.get(item);
               histogr.increment(value);
            }
        return histogr;
    }
}
