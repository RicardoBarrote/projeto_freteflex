package tech.ricardo.freteflex.domain;

import org.springframework.stereotype.Component;

@Component(value = "standardShippingCalculator")
public class StandardShippingCalculator implements ShippingCalculator {


    @Override
    public Double calculate(Double distance, Double weight) {
        return weight * 1.0 + distance * 0.5;
    }
}
