package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coupon {

    @Id
    @Column(name = "coupon_id", nullable = false)
    private int  couponId;

    @Column(name = "coupon_name", nullable = false)
    private String couponName;

    @Column(name = "offer_description", nullable = false)
    private String offerDescription;

    @Column(name = "creation_date", nullable = false)
    private String creationDate;

    @Column(name = "validity", nullable = false)
    private String validity;

    @Column(name = "percentage", nullable = false)
    private int percentage;

    @Column(name = "total", nullable = false)
    private double total;

    @Column(name = "item_id", nullable = false)
    private int  itemId;

    @Column(name = "restaurant_id", nullable = false)
    private int  restaurantId;

    @Column(name = "points", nullable = false)
    private int points;

    @Column(name = "points_type", nullable = false)
    private String pointsType;

    @Column(name = "offer_type", nullable = false)
    private String offerType;

    @Column(name = "redeem", nullable = false)
    private Boolean redeem;

}
