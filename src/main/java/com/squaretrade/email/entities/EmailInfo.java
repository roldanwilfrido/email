package com.squaretrade.email.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emailInfo")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmailInfo {
    @Id
    public String email;

    public String name;
}
