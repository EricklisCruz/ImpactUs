package com.impactus.Impactus.domain.order;

import com.impactus.Impactus.domain.product.Product;
import com.impactus.Impactus.domain.user.Administrator;
import com.impactus.Impactus.domain.user.Customer;
import com.impactus.Impactus.enums.deliveryStatus.DeliveryStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = -7078957593547000359L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product productId;
    private LocalDateTime orderDate;
    private LocalDateTime deliveryDate;
    private DeliveryStatus deliveryStatus;
    private Integer totalAmount;
    @ManyToOne
    private Customer customerId;
    @ManyToOne
    private Administrator administratorId;

    public Order(LocalDateTime orderDate, LocalDateTime deliveryDate, DeliveryStatus deliveryStatus, Integer totalAmount) {
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.totalAmount = totalAmount;
    }
}
