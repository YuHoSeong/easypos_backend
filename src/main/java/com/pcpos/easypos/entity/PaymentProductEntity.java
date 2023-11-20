package com.pcpos.easypos.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PaymentProduct")
@Table(name = "PaymentProduct")
public class PaymentProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentProductIdx;
    private Integer paymentIdx;
    private Integer productIdx;
    private String productName;
    private Integer price;
    private Integer count;
    private LocalDateTime createdAt;
}
