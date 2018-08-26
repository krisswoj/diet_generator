package pl.krzysiek.repository;
import pl.krzysiek.domain.User;

import java.sql.Connection;
import java.util.List;
import java.sql.SQLException;


public interface UserRepository {

    public List<User> getAll();
    public User getById(int id) throws SQLException;
    public int addUser(User user);
    public int deleteUser(User user) throws SQLException;
    public void updateUser(int oldId, User user) throws SQLException;
    public void dropTable() throws SQLException;
    public Connection getConnection();
    public void setConnection(Connection connection) throws SQLException;

}