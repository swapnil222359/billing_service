package com.billing.service;

import com.billing.model.Coupon;
import com.billing.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public void saveCoupon(Map<Integer, List<Coupon>> restaurantCouponMap) {
        restaurantCouponMap.entrySet().stream().forEach(entry -> {
            entry.getValue().stream().forEach(coupon -> {
                coupon.setRestaurantId(entry.getKey());
                offerRepository.save(coupon);
            });
        });
    }
}
