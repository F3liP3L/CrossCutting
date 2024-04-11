package co.edu.uco.crosscutting.util;

import co.edu.uco.crosscutting.exception.GeneralException;

import java.sql.Connection;
import java.sql.SQLException;

public class UtilSqlConnection {
    public UtilSqlConnection() {}

    public static boolean isClosed(Connection sql) {

        if(UtilObject.getUtilObject().isNull(sql)) {
            throw GeneralException.build("Connection is null");
        }
        try {
            return sql.isClosed();
        } catch (SQLException exception) {
            throw GeneralException.build("Problems trying to validate if connection was closed", exception);

        }
    }
    public static boolean isOpen(Connection connection) {
        return !isClosed(connection);
    }
}
