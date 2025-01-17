package com.scaler.splitwiseseptember2024.dto;

import com.scaler.splitwiseseptember2024.models.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transaction {
    private User payer;
    private User receiver;
    private double amount;
}


// A -> B = Rs. 500
