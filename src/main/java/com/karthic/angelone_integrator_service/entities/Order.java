package com.karthic.angelone_integrator_service.entities;

import com.karthic.angelone_integrator_service.constants.CommonConstants;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = CommonConstants.ORDERS)
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private String tradingName;
    private String symbolToken;
    private Integer quantity;
    private Double price;
    private String exchange;
    private String orderType;
    private String productType;
    private String transactionType;
    private String stopLoss;
    private String latestUniqueOrderId; // Old unique IDs have to be tracked in audit history table.
}
