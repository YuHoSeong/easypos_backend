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
@Entity(name = "MeterialIncoming")
@Table(name = "MeterialIncoming")
public class MeterialIncomingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer meterialIncomingIdx;
    private Integer meterialIdx;
    private Integer count;
    private LocalDateTime createdAt;

}
