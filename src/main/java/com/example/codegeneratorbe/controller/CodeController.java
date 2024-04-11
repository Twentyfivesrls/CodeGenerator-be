package com.example.codegeneratorbe.controller;

import com.example.codegeneratorbe.entity.Code;
import com.example.codegeneratorbe.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/code")
@CrossOrigin("*")
@RestController
public class CodeController {

    private final CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Code> saveCode(@RequestBody Code code) {

        Code savedCode = codeService.saveCode(code);
        if (savedCode == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.ok(savedCode);
    }

}
