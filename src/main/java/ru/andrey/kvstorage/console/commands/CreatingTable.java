package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CreatingTable implements DatabaseCommand {
    String databaseName;
    String tableName;
    ExecutionEnvironment env;

    public CreatingTable(String databaseName, String tableName, ExecutionEnvironment env) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.env = env;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> database = env.getDatabase(databaseName);
        if (database.isEmpty()) {
            return DatabaseCommandResult.error("This database don`t exists");
        }
        try {
            database.get().createTableIfNotExists(tableName);
            return DatabaseCommandResult.success(null);
        } catch (DatabaseException exception) {
            return DatabaseCommandResult.error(exception.getMessage());
        }
    }
}
