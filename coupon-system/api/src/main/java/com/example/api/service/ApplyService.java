package com.example.api.service;

import org.springframework.stereotype.Service;

import com.example.api.domain.Coupon;
import com.example.api.producer.CouponCreateProducer;
import com.example.api.repository.CouponCountRepository;
import com.example.api.repository.CouponRepository;

@Service
public class ApplyService {

	private final CouponRepository couponRepository;

	private final CouponCountRepository couponCountRepository;

	private final CouponCreateProducer couponCreateProducer;

	public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository,
						CouponCreateProducer couponCreateProducer) {
		this.couponRepository = couponRepository;
		this.couponCountRepository = couponCountRepository;
		this.couponCreateProducer = couponCreateProducer;
	}

	public void applay(Long userId) {
		long count = couponCountRepository.increment();

		if (count > 100) {
			return;
		}

		// couponRepository.save(new Coupon(userId));
		couponCreateProducer.create(userId);
	}
}
