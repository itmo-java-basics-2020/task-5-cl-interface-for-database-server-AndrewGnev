package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.DatabaseCommands;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

import java.util.stream.Stream;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {

    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        if (commandText == null || commandText.isEmpty())
            return DatabaseCommandResult.error("Incorrect input format");

        String[] args = commandText.split(" ");

        try {
            String commandName = args[0];
            args = Stream.of(args).skip(1).toArray(String[]::new);
            return DatabaseCommands.valueOf(commandName).getCommand(args, env).execute();
        } catch (Exception exception) {
            return DatabaseCommandResult.error("Incorrect input format");
        }
    }
}
