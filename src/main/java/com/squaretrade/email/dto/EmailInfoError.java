package com.squaretrade.email.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class EmailInfoError {
    public Instant time;
    public Integer status;
    public String message;

}
