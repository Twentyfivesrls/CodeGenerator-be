package com.example.codegeneratorbe.service;

import com.example.codegeneratorbe.entity.Code;
import com.example.codegeneratorbe.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Service
public class CodeService {

    private final CodeRepository codeRepository;

    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Code saveCode(Code code) {

        if (ObjectUtils.isEmpty(code)) {
            return null;
        }

        if (codeRepository.findByDeviceId(code.getDeviceId()).isPresent()) {
            return codeRepository.findByDeviceId(code.getDeviceId()).get();
        }

        String uuid = UUID.randomUUID().toString().replace("-", "");
        uuid = uuid.substring(0, 5).toUpperCase();
        while(codeRepository.findByCouponCode(uuid).isPresent()) {
            uuid = UUID.randomUUID().toString().replace("-", "");
            uuid = uuid.substring(0, 5).toUpperCase();
        }
        code.setCouponCode(uuid);

        return codeRepository.save(code);
    }
}
