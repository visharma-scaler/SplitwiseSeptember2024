package com.scaler.splitwiseseptember2024.commandexecutor;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private final List<Command> commands;

    public CommandExecutor(UserSettleUpCommand userSettleUpCommand,
                           ExitCommand exitCommand) {
        this.commands = new ArrayList<>();
        addCommand(userSettleUpCommand);
        addCommand(exitCommand);
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public void execute(String input) {
        commands.stream()
                .filter(command -> command.matches(input))
                .findFirst()
                .ifPresent(command -> command.execute(input));
    }
}
