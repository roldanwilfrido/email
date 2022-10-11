package com.squaretrade.email.controllers;

import com.squaretrade.email.dto.EmailInfoDTO;
import com.squaretrade.email.services.EmailInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/squaretrade/email")
public class EmailInfoController {
    private final EmailInfoService emailInfoService;

    @Autowired
    public EmailInfoController(EmailInfoService emailInfoService) {
        this.emailInfoService = emailInfoService;
    }

    @PostMapping
    public ResponseEntity<EmailInfoDTO> create(@Valid @RequestBody EmailInfoDTO emailInfoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(emailInfoService.create(emailInfoRequest));
    }
}
