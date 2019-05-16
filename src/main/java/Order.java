import java.util.ArrayList;
import java.util.Collection;

public class Order {

    Collection<OrderEntry> entries;

    public Collection<OrderEntry> getEntries() {
        return entries;
    }

    public void setEntries(Collection<OrderEntry> entries) {
        this.entries = entries;
    }

    public void addEntry(OrderEntry entry)
    {
        if(this.entries==null)
            this.entries = new ArrayList<>();
        this.entries.add(entry);
    }
}
