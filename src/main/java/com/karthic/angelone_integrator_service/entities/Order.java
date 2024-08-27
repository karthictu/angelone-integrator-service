package com.karthic.angelone_integrator_service.entities;

import com.karthic.angelone_integrator_service.constants.CommonConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name = CommonConstants.ORDERS)
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column
    private String orderId;
    @Column
    private String userId;
    @Column
    private String tradingName;
    @Column
    private String symbolToken;
    @Column
    private Integer quantity;
    @Column
    private Double price;
    @Column
    private String exchange;
    @Column
    private String orderType;
    @Column
    private String productType;
    @Column
    private String transactionType;
    @Column
    private String stopLoss;
    @Column
    private String uniqueOrderId; // Old unique IDs have to be tracked in audit history table.
}
