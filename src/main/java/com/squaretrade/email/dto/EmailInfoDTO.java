package com.squaretrade.email.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EmailInfoDTO {
    @Email
    public String email;
    public String name;
}
