package com.scaler.splitwiseseptember2024;

import com.scaler.splitwiseseptember2024.commandexecutor.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@EnableJpaAuditing
@SpringBootApplication
public class SplitwiseSeptember2024Application implements CommandLineRunner {

    private final CommandExecutor commandExecutor;
    private final Scanner scanner;

    public SplitwiseSeptember2024Application(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseSeptember2024Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            String input = scanner.nextLine();
            commandExecutor.execute(input);
        }
    }
}
