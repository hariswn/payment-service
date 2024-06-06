package com.harry.payment_service.service.impl;

import com.harry.payment_service.model.PaymentModel;
import com.harry.payment_service.repository.PaymentRepository;
import com.harry.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;


    @Override
    public void registerPayment(PaymentModel paymentModel) {
        this.repository.registerPayment(paymentModel);
    }

    @Override
    public List<PaymentModel> getPaymentTypes() {
        return this.repository.getPaymentTypes();
    }
}
