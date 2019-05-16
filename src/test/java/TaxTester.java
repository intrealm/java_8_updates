import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.prefs.Preferences;

public class TaxTester {


    @Test
    public void getAllTaxesforOrder()
    {
        Order order = new Order();
        OrderEntry entry1 = new OrderEntry();
        TaxValue e1v1 = new TaxValue(5,"one");
        TaxValue e1v2 = new TaxValue(5,"two");

        OrderEntry entry2 = new OrderEntry();
        TaxValue e2v1 = new TaxValue(5,"three");
        TaxValue e2v2 = new TaxValue(5,"four");

        order.addEntry(entry1);
        order.addEntry(entry2);

        entry1.addTaxValue(e1v1);entry1.addTaxValue(e2v1);entry2.addTaxValue(e2v2);entry2.addTaxValue(e1v2);


        //start

        List<TaxValue> listOfTaxes =
  //      int value =
                order.
                getEntries().
                stream().
                map(OrderEntry::getTaxes).
                collect(ArrayList::new, Collection::addAll,Collection::addAll);
               // .stream().mapToInt(TaxValue::getValue).sum();
//System.out.println(value);
        for(TaxValue tv :listOfTaxes)
            System.out.println(tv);
    }

    @Test
    public void test_flat_map()
    {
        Order order = new Order();
        OrderEntry entry1 = new OrderEntry();
        TaxValue e1v1 = new TaxValue(5,"one");
        TaxValue e1v2 = new TaxValue(5,"two");

        OrderEntry entry2 = new OrderEntry();
        TaxValue e2v1 = new TaxValue(5,"three");
        TaxValue e2v2 = new TaxValue(5,"four");

        order.addEntry(entry1);
        order.addEntry(entry2);

        entry1.addTaxValue(e1v1);entry1.addTaxValue(e2v1);entry2.addTaxValue(e2v2);entry2.addTaxValue(e1v2);


        int value= order.getEntries().stream()
                .flatMap(oe->oe.getTaxes().stream())
                .mapToInt(TaxValue::getValue).sum();
        System.out.println(value);
    }
}
