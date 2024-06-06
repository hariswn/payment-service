package com.harry.payment_service.controller;

import com.harry.payment_service.model.PaymentModel;
import com.harry.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerPayment(@RequestBody PaymentModel paymentModel) {
        this.paymentService.registerPayment(paymentModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentModel>> getPaymentTypes() {
        return new ResponseEntity<>(this.paymentService.getPaymentTypes(), HttpStatus.OK);
    }
}
