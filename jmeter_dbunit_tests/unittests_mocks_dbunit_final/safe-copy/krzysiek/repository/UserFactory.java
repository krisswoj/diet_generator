package pl.krzysiek.repository;

import org.springframework.context.annotation.Bean;
import pl.krzysiek.services.UserImpl;

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