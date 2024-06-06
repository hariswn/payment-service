package com.harry.payment_service.service;

import com.harry.payment_service.model.PaymentModel;
import com.harry.payment_service.repository.PaymentRepository;
import com.harry.payment_service.service.impl.PaymentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PaymentServiceImplTest {

    @Mock
    private PaymentRepository mockRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterPayment() {
        PaymentModel paymentModel = new PaymentModel();
        paymentService.registerPayment(paymentModel);
        verify(mockRepository, times(1)).registerPayment(paymentModel);
    }

    @Test
    public void testGetPaymentTypes() {
        List<PaymentModel> expectedPaymentTypes = Collections.singletonList(new PaymentModel());
        when(mockRepository.getPaymentTypes()).thenReturn(expectedPaymentTypes);

        List<PaymentModel> actualPaymentTypes = paymentService.getPaymentTypes();

        assertEquals(expectedPaymentTypes, actualPaymentTypes);
    }
}
