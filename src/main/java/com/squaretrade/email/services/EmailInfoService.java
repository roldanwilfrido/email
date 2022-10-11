package com.squaretrade.email.services;

import com.squaretrade.email.dto.EmailInfoDTO;
import com.squaretrade.email.entities.EmailInfo;
import com.squaretrade.email.repositories.EmailInfoRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailInfoService {
    private final EmailInfoRepository emailInfoRepository;

    @Autowired
    public EmailInfoService(EmailInfoRepository emailInfoRepository) {
        this.emailInfoRepository = emailInfoRepository;
    }

    public EmailInfoDTO create(EmailInfoDTO emailInfoRequest) {
        emailInfoChecker(emailInfoRequest.getEmail());
        EmailInfo entity = mapEmailInfo(emailInfoRequest);
        return emailInfoTranslator(emailInfoRepository.save(entity));
    }

    private void emailInfoChecker(String email) {
        if (emailInfoRepository.findById(email).isPresent()) {
            throw new EntityExistsException();
        }
    }

    private EmailInfo mapEmailInfo(EmailInfoDTO emailInfoRequest) {
        return EmailInfo.builder()
                .email(emailInfoRequest.getEmail())
                .name(emailInfoRequest.getName())
                .build();
    }

    private EmailInfoDTO emailInfoTranslator(EmailInfo entity) {
        return EmailInfoDTO.builder()
                .email(entity.getEmail())
                .name(entity.getName())
                .build();
    }
}
