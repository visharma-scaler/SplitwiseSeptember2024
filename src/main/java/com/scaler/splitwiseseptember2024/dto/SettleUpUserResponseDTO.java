package com.scaler.splitwiseseptember2024.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SettleUpUserResponseDTO {
    private ResponseStatus status;
    private List<Transaction> transactions;
}
