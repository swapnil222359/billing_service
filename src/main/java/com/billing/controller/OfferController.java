package com.billing.controller;

import com.billing.model.Coupon;
import com.billing.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(produces = "application/json", consumes = "application/json")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping(value = "/coupon")
    public void saveCoupon(@RequestBody Map<Integer, List<Coupon>> restaurantCouponMap) {
        offerService.saveCoupon(restaurantCouponMap);
    }

}
