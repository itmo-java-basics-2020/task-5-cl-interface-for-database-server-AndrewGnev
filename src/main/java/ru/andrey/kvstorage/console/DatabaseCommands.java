package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.console.commands.CreatingDatabase;
import ru.andrey.kvstorage.console.commands.CreatingTable;
import ru.andrey.kvstorage.console.commands.ReadingKey;
import ru.andrey.kvstorage.console.commands.UpdatingKey;
import ru.andrey.kvstorage.exception.DatabaseException;

public enum DatabaseCommands {

    CREATE_DATABASE {
        @Override
        public DatabaseCommand getCommand(String[] args, ExecutionEnvironment env) throws DatabaseException {
            if (args.length != 1) throw new DatabaseException("Incorrect number of arguments");
            return new CreatingDatabase(args[0], env);
        }
    },

    CREATE_TABLE {
        @Override
        public DatabaseCommand getCommand(String[] args, ExecutionEnvironment env) throws DatabaseException {
            if (args.length != 2) throw new DatabaseException("Incorrect number of arguments");
            return new CreatingTable(args[0], args[1], env);
        }
    },
    UPDATE_KEY {
        @Override
        public DatabaseCommand getCommand(String[] args, ExecutionEnvironment env) throws DatabaseException {
            if (args.length != 4) throw new DatabaseException("Incorrect number of arguments");
            return new UpdatingKey(args[0], args[1], args[2], args[3], env);
        }
    },
    READ_KEY {
        @Override
        public DatabaseCommand getCommand(String[] args, ExecutionEnvironment env) throws DatabaseException {
            if (args.length != 3) throw new DatabaseException("Incorrect number of arguments");
            return new ReadingKey(args[0], args[1], args[2], env);
        }
    };

    public abstract DatabaseCommand getCommand(String[] args, ExecutionEnvironment env) throws DatabaseException;
}
