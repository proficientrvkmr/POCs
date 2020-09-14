package com.example.awsserverlessdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private int orderId;
    private String customerId;
    private BigDecimal totalAmount;
    private BigDecimal taxAmount;
}
