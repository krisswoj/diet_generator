package pl.krzysiek.tests.domain.dbunit;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import org.springframework.beans.factory.annotation.Autowired;
import pl.krzysiek.domain.User;
import pl.krzysiek.repository.UserRepository;
import pl.krzysiek.services.UserImpl;

import java.sql.DriverManager;

@RunWith(JUnit4.class)
public class UserDbunitTest extends DBTestCase {
    public static String url = "jdbc:hsqldb:hsql://localhost/workdb";

    UserRepository userRepository;

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        userRepository = new UserImpl(DriverManager.getConnection(url));
    }

    @Test
    public void doNothing() {
        assertEquals(4, userRepository.getAll().size());
    }

    @Test
    public void checkAdding() throws Exception{

        User user = new User("Maciek", 33);
        int userId = userRepository.addUser(user);
        assertEquals(userRepository.getById(userId).getName(), user.getName());

        // Data verification

        IDataSet dbDataSet = this.getConnection().createDataSet();
        ITable actualTable = dbDataSet.getTable("USERS");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(actualTable, new String[] { "ID" });
        IDataSet expectedDataSet = getDataSet("ds-2.xml");
        ITable expectedTable = expectedDataSet.getTable("USERS");
        Assertion.assertEquals(expectedTable, filteredTable);

    }

    @Test
    public void checkRead() throws Exception{

        assertEquals("Stefan", userRepository.getById(1).getName());

        IDataSet dbDataSet = this.getConnection().createDataSet();
        ITable actualTable = dbDataSet.getTable("USERS");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(actualTable, new String[] { "ID" });
        IDataSet expectedDataSet = getDataSet("ds-2.xml");
        ITable expectedTable = expectedDataSet.getTable("USERS");
        Assertion.assertEquals(expectedTable, filteredTable);
    }

    @Test
    public void checkUpdate() throws Exception{

        User user = userRepository.getById(1);
        assertNotSame(27, user.getAge());
        user.setAge(27);
        userRepository.updateUser(1, user);
        assertEquals(user.getAge(), 27);

        IDataSet dbDataSet = this.getConnection().createDataSet();
        ITable actualTable = dbDataSet.getTable("USERS");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(actualTable, new String[] { "ID" });
        IDataSet expectedDataSet = getDataSet("ds-3.xml");
        ITable expectedTable = expectedDataSet.getTable("USERS");
        Assertion.assertEquals(expectedTable, filteredTable);

    }

    @Test
    public void checkDelete() throws Exception{

        User user = new User(6,"Arkadiusz", 29);

        userRepository.deleteUser(user);

        assertNull(userRepository.getById(user.getId()).getName());

        IDataSet dbDataSet = this.getConnection().createDataSet();
        ITable actualTable = dbDataSet.getTable("USERS");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(actualTable, new String[] { "ID" });
        IDataSet expectedDataSet = getDataSet("ds-4.xml");
        ITable expectedTable = expectedDataSet.getTable("USERS");
        Assertion.assertEquals(expectedTable, filteredTable);
    }

    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.INSERT;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return this.getDataSet("ds-1.xml");
    }

    /**
     * Returns dataset for selected resource
     * @param datasetName filename in resources
     * @return flat xml data set
     * @throws Exception when there is a problem with opening dataset
     */
    protected IDataSet getDataSet(String datasetName) throws Exception {
        URL url = getClass().getClassLoader().getResource(datasetName);
        FlatXmlDataSet ret = new FlatXmlDataSetBuilder().build(url.openStream());
        return ret;
    }
}
