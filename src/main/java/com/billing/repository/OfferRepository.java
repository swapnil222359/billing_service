package com.billing.repository;

import com.billing.model.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OfferRepository extends CrudRepository<Coupon,String> {

    Coupon save(Coupon coupon);

    List<Coupon> findByCouponId(int id);

}
