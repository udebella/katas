package fr.money;

import java.math.BigDecimal;

public interface RateVisitor {
    <T extends RateVisitor> T visit(BigDecimal rate);
}
