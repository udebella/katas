package fr.money;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Amount {
    private final int value;

    public Amount(int value) {
        this.value = value;
    }

    public Amount cents() {
        throw new NotImplementedException();
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
