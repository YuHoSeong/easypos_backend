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
@Entity(name = "PointUsage")
@Table(name = "PointUsage")
public class PointUsageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pointUsageIdx;
    private Integer customerIdx;
    private Integer paymentIdx;
    private Integer value;
    private LocalDateTime createdAt;
}
