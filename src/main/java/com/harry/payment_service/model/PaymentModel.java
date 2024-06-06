package com.harry.payment_service.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentModel {

    private long id;
    private String name;
}
