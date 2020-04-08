package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {

    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult success(String result) {
        return new DatabaseCommandResultClass(result, DatabaseCommandStatus.SUCCESS, null);
    }

    static DatabaseCommandResult error(String message) {
        return new DatabaseCommandResultClass(null, DatabaseCommandStatus.FAILED, message);
    }
}