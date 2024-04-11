package com.example.codegeneratorbe.repository;

import com.example.codegeneratorbe.entity.Code;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends MongoRepository<Code, String> {
    Code findByDeviceId(String deviceId);
}
