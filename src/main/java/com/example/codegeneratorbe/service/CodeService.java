package com.example.codegeneratorbe.service;

import com.example.codegeneratorbe.entity.Code;
import com.example.codegeneratorbe.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Service
public class CodeService {

    @Autowired
    private CodeRepository codeRepository;

    public Code saveCode(Code code) {

        if (ObjectUtils.isEmpty(code)){
            return null;
        }

        if (codeRepository.findByDeviceId(code.getDeviceId()) != null){
            return codeRepository.findByDeviceId(code.getDeviceId());
        }

        String uuid = UUID.randomUUID().toString().replace("-", "");
        uuid = uuid.substring(0, 5);
        code.setCouponCode(uuid);

        return codeRepository.save(code);
    }
}
