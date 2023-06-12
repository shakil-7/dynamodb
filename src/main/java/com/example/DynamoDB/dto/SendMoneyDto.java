package com.example.DynamoDB.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMoneyDto {
    private String senderAccountNo;
    private String receiverAccountNo;
    private double amount;
}
