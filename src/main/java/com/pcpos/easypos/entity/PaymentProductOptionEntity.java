package com.pcpos.easypos.entity;

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
@Entity(name = "PaymentProductOption")
@Table(name = "PaymentProductOption")
public class PaymentProductOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentProductOptionIdx;
    private Integer paymentProductIdx;
    private Integer optionIdx;
    private String optionName;
    private Integer price;
}
