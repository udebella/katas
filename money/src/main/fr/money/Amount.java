package fr.money;

public class Amount {
    private final int value;

    public Amount(int value) {
        this.value = value;
    }

    public Amount cents() {
        return new Amount(value / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
