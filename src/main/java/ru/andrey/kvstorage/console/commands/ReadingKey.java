package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class ReadingKey implements DatabaseCommand {
    String databaseName;
    String tableName;
    String key;
    ExecutionEnvironment env;

    public ReadingKey(String databaseName, String tableName, String key, ExecutionEnvironment env) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.key = key;
        this.env = env;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> database = env.getDatabase(databaseName);
        if (database.isEmpty()) {
            return DatabaseCommandResult.error("Database don`t exists");
        }
        try {
            return DatabaseCommandResult.success(database.get().read(tableName, key));
        } catch (DatabaseException exception) {
            return DatabaseCommandResult.error(exception.getMessage());
        }

    }
}
