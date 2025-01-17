package com.scaler.splitwiseseptember2024.controller;

import com.scaler.splitwiseseptember2024.dto.*;
import com.scaler.splitwiseseptember2024.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


// Users can settle up. The application should show a list of transactions,
// which when executed will ensure that the user no longer owes or receives
// money from any other user. Note that this need not settle any other users.

@Controller
public class SettleUpController {

    private final SettleUpService settleUpService;

    @Autowired
    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    public SettleUpUserResponseDTO settleUpUser(SettleUpUserRequestDTO requestDTO) {
        SettleUpUserResponseDTO responseDTO = new SettleUpUserResponseDTO();
        try {
            List<Transaction> transactions = settleUpService.settleUpUser(requestDTO.getUserId());
            responseDTO.setStatus(ResponseStatus.SUCCESS);
            responseDTO.setTransactions(transactions);
        } catch (Exception e) {
            responseDTO.setStatus(ResponseStatus.FAILURE);
        }

        return responseDTO;
    }


    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO requestDTO) {
        SettleUpGroupResponseDTO responseDTO = new SettleUpGroupResponseDTO();
        try {
            List<Transaction> transactions = settleUpService.settleUpGroup(requestDTO.getGroupId());
            responseDTO.setStatus(ResponseStatus.SUCCESS);
            responseDTO.setTransactions(transactions);
        } catch (Exception e) {
            responseDTO.setStatus(ResponseStatus.FAILURE);
        }

        return responseDTO;
    }


}
