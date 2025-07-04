package com.eventostec.api.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.eventostec.api.domain.coupon.Coupon;
import com.eventostec.api.domain.coupon.CouponRequestDTO;
import com.eventostec.api.domain.event.Event;
import com.eventostec.api.repositories.CouponRepositorie;
import com.eventostec.api.repositories.EventRepositories;

@Service
public class CouponService {

    @Value("${aws.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    @Autowired
    private CouponRepositorie couponRepositorie;
    @Autowired
    private EventRepositories eventRepositories;

    public Coupon addCouponToEvent(UUID eventId, CouponRequestDTO couponData) {

        Event event = eventRepositories.findById(eventId).orElseThrow(()-> new IllegalArgumentException("Event not found"));

        Coupon coupon = new Coupon();
        coupon.setEvent(event);
        coupon.setCode(couponData.code());
        coupon.setDiscount(couponData.discount());
        coupon.setValid(new Date(couponData.valid()));

        return couponRepositorie.save(coupon);

    }
}
