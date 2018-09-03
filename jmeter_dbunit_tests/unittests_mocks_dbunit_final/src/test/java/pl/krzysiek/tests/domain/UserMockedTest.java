package pl.krzysiek.tests.domain;

import static org.junit.Assert.*;

import org.dbunit.DatabaseUnitException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;

import pl.krzysiek.domain.User;
import pl.krzysiek.repository.UserRepository;
import pl.krzysiek.services.UserImpl;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RunWith(MockitoJUnitRunner.class)
public class UserMockedTest {

    UserRepository userRepository;

    @Mock
    Connection connectionMock;

    @Mock
    PreparedStatement insertStatementMock;

    @Mock
    PreparedStatement updateStatementMock;

    @Mock
    PreparedStatement deleteStatementMock;

    @Mock
    PreparedStatement getAllStatementMock;

    @Mock
    PreparedStatement getByIdStatementMock;

    @Mock
    UserRepository userRepositoryMock;


    @Before
    public void setupDatabase() throws SQLException {


        when(connectionMock.prepareStatement("INSERT INTO Users (NAME, AGE) VALUES (?,?)")).thenReturn(insertStatementMock);
        when(connectionMock.prepareStatement("UPDATE Users SET AGE = ? WHERE ID = ?")).thenReturn(updateStatementMock);
        when(connectionMock.prepareStatement("DELETE FROM Users WHERE ID = ?")).thenReturn(deleteStatementMock);
        when(connectionMock.prepareStatement("SELECT * FROM Users")).thenReturn(getAllStatementMock);
        when(connectionMock.prepareStatement("SELECT * FROM Users WHERE ID = ?")).thenReturn(getByIdStatementMock);

        userRepository = new UserImpl();
        userRepositoryMock = mock(UserImpl.class);
        userRepository.setConnection(connectionMock);

        verify(connectionMock).prepareStatement("INSERT INTO Users (NAME, AGE) VALUES (?,?)");
        verify(connectionMock).prepareStatement("SELECT * FROM Users");
        verify(connectionMock).prepareStatement("SELECT * FROM Users WHERE ID = ?");
        verify(connectionMock).prepareStatement("UPDATE Users SET AGE = ? WHERE ID = ?");
        verify(connectionMock).prepareStatement("DELETE FROM Users WHERE ID = ?");

    }

    @Test
    public void checkUpdate() throws Exception {

        User user1 = new User(1, "krzysztof", 24);
        doReturn(user1).when(userRepositoryMock).getById(1);

        User updateAge = userRepositoryMock.getById(1);
        updateAge.setAge(27);
        updateAge.setName("krzysztof");
        userRepository.updateUser(1, updateAge);

        User user2 = new User(2, "Melanie", 21);
        doReturn(user2).when(userRepositoryMock).getById(2);

        assertEquals(userRepositoryMock.getById(1).getAge(), updateAge.getAge());
        verify(updateStatementMock, times(1)).setInt(1, 27);
        assertThat(userRepositoryMock.getById(2).getName(), not(userRepositoryMock.getById(1).getName()));
        verify(updateStatementMock).executeUpdate();

    }

    @Test
    public void checkAdding() throws Exception {
        when(insertStatementMock.executeUpdate()).thenReturn(1);

        User user = new User(3, "krzysztof_wojdak", 24);
        userRepository.addUser(user);

        verify(insertStatementMock, times(1)).setString(1, "krzysztof_wojdak");
        verify(insertStatementMock, times(1)).setInt(2, 24);
        verify(insertStatementMock).executeUpdate();
    }

    abstract class AbstractResultSet implements ResultSet {
        int i = 0;

        @Override
        public int getInt(String columnLabel) throws SQLException {
            switch (columnLabel) {
                case "id":
                    return 3;
                case "age":
                    return 24;
                default:
                    return 0;
            }
        }

        @Override
        public String getString(String columnLabel) throws SQLException {
            return "krzysztof_wojdak";
        }

        @Override
        public boolean next() throws SQLException {
            if (i == 1)
                return false;
            i++;
            return true;
        }
    }


    abstract class AbstractResultSetById implements ResultSet {
        int i = 0;

        @Override
        public int getInt(String columnLabel) throws SQLException {
            switch (columnLabel) {
                case "id":
                    return 1;
                case "age":
                    return 24;
                default:
                    return 0;
            }
        }

        @Override
        public String getString(String columnLabel) throws SQLException {
            return "krzysztof_wojdakkk";
        }

        @Override
        public boolean next() throws SQLException {
            if (i == 1)
                return false;
            i++;
            return true;
        }
    }


    @Test
    public void checkGetting() throws Exception {
        AbstractResultSet mockedResultSet = mock(AbstractResultSet.class);
        when(mockedResultSet.next()).thenCallRealMethod();
        when(mockedResultSet.getInt("id")).thenCallRealMethod();
        when(mockedResultSet.getString("name")).thenCallRealMethod();
        when(mockedResultSet.getInt("age")).thenCallRealMethod();
        when(getAllStatementMock.executeQuery()).thenReturn(mockedResultSet);

        assertEquals(1, userRepository.getAll().size());

        verify(getAllStatementMock, times(1)).executeQuery();
        verify(mockedResultSet, times(1)).getInt("id");
        verify(mockedResultSet, times(1)).getString("name");
        verify(mockedResultSet, times(1)).getInt("age");
        verify(mockedResultSet, times(2)).next();
    }

    @Test
    public void checkGettingById() throws Exception {
        AbstractResultSetById mockedResultSet = mock(AbstractResultSetById.class);
        when(mockedResultSet.next()).thenCallRealMethod();
        when(mockedResultSet.getInt("id")).thenCallRealMethod();
        when(mockedResultSet.getString("name")).thenCallRealMethod();
        when(mockedResultSet.getInt("age")).thenCallRealMethod();
        when(getByIdStatementMock.executeQuery()).thenReturn(mockedResultSet);

        assertNotNull(userRepository.getById(1));

        verify(getByIdStatementMock, times(1)).executeQuery();
        verify(mockedResultSet, times(1)).getInt("id");
        verify(mockedResultSet, times(1)).getString("name");
        verify(mockedResultSet, times(1)).getInt("age");
        verify(mockedResultSet, times(1)).next();
    }


    @Test
    public void checkDelete() throws SQLException {

        when(deleteStatementMock.executeUpdate()).thenReturn(1);
        User user = new User(1, "Melani", 23);

        assertEquals(1, userRepository.deleteUser(user));
        verify(deleteStatementMock, times(1)).setInt(1, user.getId());
        verify(deleteStatementMock).executeUpdate();
    }

}