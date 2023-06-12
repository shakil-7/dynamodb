package com.example.DynamoDB.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceRangeDto {
    private String userId;
    private double lowerRange;
    private double upperRange;
}
