package com.harry.payment_service.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.harry.payment_service.model.PaymentModel;
import com.harry.payment_service.service.PaymentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@WebMvcTest(PaymentController.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig.class})
public class PaymentControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private PaymentService paymentService;


    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetPaymentTypes() throws Exception {
        Mockito.when(paymentService.getPaymentTypes()).thenReturn(List.of(PaymentModel.builder().build()));
        mockMvc.perform(get("/payment/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }

    @Test
    public void testRegisterPayment() throws Exception {
        PaymentModel paymentModel = PaymentModel.builder()
                .id(101)
                .name("NEFT")
                .build();
        Mockito.doNothing().when(paymentService).registerPayment(paymentModel);
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(post("/payment/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(paymentModel)))
                .andExpect(status().isCreated());
    }
}
