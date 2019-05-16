import java.util.Objects;

public class TaxValue {

    private int value;

    private String code;

    public TaxValue(int value, String code) {
        this.value = value;
        this.code = code;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxValue taxValue = (TaxValue) o;
        return value == taxValue.value &&
                code.equals(taxValue.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, code);
    }


    @Override
    public String toString() {
        return "TaxValue{" +
                "value=" + value +
                ", code='" + code + '\'' +
                '}';
    }
}
