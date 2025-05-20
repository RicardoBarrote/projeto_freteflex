package tech.ricardo.freteflex.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tech.ricardo.freteflex.domain.ExpressShippingCalculator;
import tech.ricardo.freteflex.domain.ShippingCalculator;
import tech.ricardo.freteflex.domain.StandardShippingCalculator;

@Service
public class ShippingService {

    private final ShippingCalculator standardShippingCalculator;
    private final ShippingCalculator expressShippingCalculator;

    public ShippingService(@Qualifier("standardShippingCalculator")
                           StandardShippingCalculator standardShippingCalculator,
                           @Qualifier("expressShippingCalculator")
                           ExpressShippingCalculator expressShippingCalculator) {
        this.standardShippingCalculator = standardShippingCalculator;
        this.expressShippingCalculator = expressShippingCalculator;
    }

    public Double calculate(String shippingType, Double distance, Double weight) {
        if (shippingType.equalsIgnoreCase("standard")) {
            return calculateStandard(distance, weight);
        } else if (shippingType.equalsIgnoreCase("express")) {
            return calculateExpress(distance, weight);
        }
        return null;
    }

    public Double calculateStandard(Double distance, Double weight) {
        return standardShippingCalculator.calculate(distance, weight);
    }

    public Double calculateExpress(Double distance, Double weight) {
        return expressShippingCalculator.calculate(distance, weight);
    }
}
