package com.scaler.splitwiseseptember2024.commandexecutor;

public interface Command {
    boolean matches(String input);

    void execute(String input);
}
