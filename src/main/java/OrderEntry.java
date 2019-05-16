import java.util.Collection;
import java.util.LinkedList;

public class OrderEntry {

    Collection<TaxValue> taxes;

    public OrderEntry() {
    }

    public OrderEntry(Collection<TaxValue> taxes) {
        this.taxes = taxes;
    }

    public Collection<TaxValue> getTaxes() {
        return taxes;
    }

    public void addTaxValue(TaxValue tv)
    {
        if(this.taxes==null)
            taxes = new LinkedList<>();
        this.taxes.add(tv);
    }

    public void setTaxes(Collection<TaxValue> taxes) {
        this.taxes = taxes;
    }
}
