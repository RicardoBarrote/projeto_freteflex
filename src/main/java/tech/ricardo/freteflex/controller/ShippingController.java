package tech.ricardo.freteflex.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.ricardo.freteflex.controller.dto.ShippingResponse;
import tech.ricardo.freteflex.service.ShippingService;

@Controller
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping(value = "shipping/calculate")
    public ResponseEntity<ShippingResponse> calculate(@RequestParam("type") String shippingType,
                                                      @RequestParam("distance") Double distance,
                                                      @RequestParam("weight") Double weight) {

        Double calculate = shippingService.calculate(shippingType, distance, weight);
        return ResponseEntity.ok(new ShippingResponse(calculate));
    }
}
