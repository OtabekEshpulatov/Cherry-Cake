package org.example.logic.database;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class DbConnection {
    private final String URL="jdbc:postgresql://localhost:5432/cherrydata";
    private final String USER="postgres";
    private final String PASSWORD="12345";
    public Connection getConnection()throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
