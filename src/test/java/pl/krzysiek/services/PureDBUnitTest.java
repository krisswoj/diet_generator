//package pl.krzysiek.services;
//
//import junit.framework.TestCase;
//import org.dbunit.Assertion;
//import org.dbunit.IDatabaseTester;
//import org.dbunit.JdbcDatabaseTester;
//import org.dbunit.database.DatabaseConnection;
//import org.dbunit.database.IDatabaseConnection;
//import org.dbunit.dataset.IDataSet;
//import org.dbunit.dataset.ITable;
//import org.dbunit.dataset.filter.DefaultColumnFilter;
//import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
//import org.junit.Ignore;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//@Ignore
//public class PureDBUnitTest extends TestCase {
//
//	IDatabaseConnection connection ;
//	private IDatabaseTester databaseTester;
//
//	protected void setUp() throws Exception {
//		Connection jdbcConnection;
//		jdbcConnection = DriverManager.getConnection(
//				"jdbc:mysql://localhost/tau", "root", "");
//		connection = new DatabaseConnection(jdbcConnection);
//
//		databaseTester = new JdbcDatabaseTester(
//				"com.mysql.jdbc.Driver", "jdbc:mysql://localhost/tau", "root", "");
//		IDataSet dataSet = new FlatXmlDataSetBuilder().build(
//				new FileInputStream(new File("src/test/resources/fullData.xml")));
//		databaseTester.setDataSet(dataSet);
//		databaseTester.onSetup();
//
//		//DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
//	}
//
////	public void test() throws Exception {
////
////		// Operacje
////
////		IDataSet dbDataSet = connection.createDataSet();
////		ITable actualTable = dbDataSet.getTable("ACCOUNT");
////		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
////				(actualTable, new String[]{"ID"});
////
////		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
////				new File("src/test/resources/personData.xml"));
////		ITable expectedTable = expectedDataSet.getTable("ACCOUNT");
////
////		Assertion.assertEquals(expectedTable, filteredTable);
////
////	}
//
//	protected void tearDown() throws Exception{
//		databaseTester.onTearDown();
//	}
//
//
//}
