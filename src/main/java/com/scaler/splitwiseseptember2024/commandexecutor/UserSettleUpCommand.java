package com.scaler.splitwiseseptember2024.commandexecutor;

import com.scaler.splitwiseseptember2024.controller.SettleUpController;
import com.scaler.splitwiseseptember2024.dto.SettleUpUserRequestDTO;
import com.scaler.splitwiseseptember2024.dto.SettleUpUserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserSettleUpCommand implements Command {

    private final SettleUpController settleUpController;

    @Autowired
    public UserSettleUpCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
//        "u1 SettleUp"
// "exit"
        String[] words = input.split(" ");
        return words.length > 1 && words[1].equals("SettleUp");
    }

    @Override
    public void execute(String input) {

        String[] words = input.split(" ");
        Long userId = Long.parseLong(words[0]);

        SettleUpUserRequestDTO settleUpUserRequestDTO = new SettleUpUserRequestDTO();
        settleUpUserRequestDTO.setUserId(userId);

        SettleUpUserResponseDTO responseDTO = settleUpController.settleUpUser(settleUpUserRequestDTO);

        System.out.println("Response is: " + responseDTO);

    }
}
