package ru.andrey.kvstorage.console;

import java.util.Optional;

public class DatabaseCommandResultClass implements DatabaseCommandResult {
    Optional<String> result;
    DatabaseCommandStatus status;
    String message;

    public DatabaseCommandResultClass(String result, DatabaseCommandStatus status, String message) {
        this.result = Optional.ofNullable(result);
        this.status = status;
        this.message = message;
    }

    @Override
    public Optional<String> getResult() {
        return result;
    }

    @Override
    public DatabaseCommandStatus getStatus() {
        return status;
    }

    @Override
    public boolean isSuccess() {
        return message == null;
    }

    @Override
    public String getErrorMessage() {
        return message;
    }
}
