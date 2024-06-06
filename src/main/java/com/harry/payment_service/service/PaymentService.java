package com.harry.payment_service.service;

import com.harry.payment_service.model.PaymentModel;

import java.util.List;

public interface PaymentService {

    void registerPayment(PaymentModel paymentModel);
    List<PaymentModel> getPaymentTypes();
}
