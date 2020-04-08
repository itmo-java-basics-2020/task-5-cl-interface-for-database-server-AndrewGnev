package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;

public class CreatingDatabase implements DatabaseCommand {

    String databaseName;
    ExecutionEnvironment env;

    public CreatingDatabase(String databaseName, ExecutionEnvironment env) {
        this.databaseName = databaseName;
        this.env = env;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        if (env.getDatabase(databaseName).isPresent()) {
            return DatabaseCommandResult.error("This name already used");
        }
        return DatabaseCommandResult.success(null);
    }
}
