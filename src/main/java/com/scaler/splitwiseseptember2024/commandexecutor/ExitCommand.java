package com.scaler.splitwiseseptember2024.commandexecutor;

import org.springframework.stereotype.Component;

@Component
public class ExitCommand implements Command {
    @Override
    public boolean matches(String input) {
        return input.equals("exit");
    }

    @Override
    public void execute(String input) {
        System.exit(0);
    }
}
