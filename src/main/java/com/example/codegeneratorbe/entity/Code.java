package com.example.codegeneratorbe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "codegenerator_code")
public class Code {

    @Id
    private String id;
    private String deviceId;
    private String couponCode;
}
