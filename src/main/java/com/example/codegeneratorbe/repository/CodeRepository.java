package com.example.codegeneratorbe.repository;

import com.example.codegeneratorbe.entity.Code;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeRepository extends MongoRepository<Code, String> {
    Optional<Code> findByDeviceId(String deviceId);
    Optional<Code> findByCouponCode(String couponCode);
}
