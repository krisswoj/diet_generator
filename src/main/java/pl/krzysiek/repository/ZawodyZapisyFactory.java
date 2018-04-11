package pl.krzysiek.repository;

import pl.krzysiek.services.ZawodyZapisyImpl;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ZawodyZapisyFactory {

    public static ZawodyZapisyRepository getInstance() {


        try {
            String url = "jdbc:hsqldb:hsql://localhost/workdb";
            return new ZawodyZapisyImpl(DriverManager.getConnection(url));
        }
        catch (SQLException e){
            return null;
        }
    }
}