package com.harry.payment_service.repository;

import com.harry.payment_service.model.PaymentModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentRepository {

    private static final List<PaymentModel> PAYMENT_MODELS = new ArrayList<>();

    public void registerPayment(PaymentModel paymentModel) {
        PAYMENT_MODELS.add(paymentModel);
    }

    public List<PaymentModel> getPaymentTypes() {
        return PAYMENT_MODELS;
    }
}
