package pl.krzysiek.repository;

import java.sql.DriverManager;
import java.sql.SQLException;


public class UserFactory {

    public static UserRepository getInstance() {

        try {
            String url = "jdbc:hsqldb:hsql://localhost/workdb";
            return new UserImpl(DriverManager.getConnection(url));
        }
        catch (SQLException e){
            return null;
        }
    }
}