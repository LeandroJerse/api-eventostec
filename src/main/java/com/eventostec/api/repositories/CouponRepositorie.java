package com.eventostec.api.repositories;

import com.eventostec.api.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponRepositorie extends JpaRepository<Coupon, UUID> {
}
