package co.edu.uco.crosscutting.util;

import co.edu.uco.crosscutting.exception.CrossCuttingException;

import java.sql.Connection;
import java.sql.SQLException;

import static co.edu.uco.crosscutting.util.UtilObject.isNull;

public final class UtilSqlConnection {
    private UtilSqlConnection() {}
    public static boolean isClosed(Connection sql) {
        if(isNull(sql)) {
            throw CrossCuttingException.build("Connection is null.");
        }
        try {
            return sql.isClosed();
        } catch (SQLException exception) {
            throw CrossCuttingException.build("Problems trying to validate if connection was closed.", exception);
        }
    }
    public static boolean isOpen(Connection connection) {
        return !isClosed(connection);
    }
}