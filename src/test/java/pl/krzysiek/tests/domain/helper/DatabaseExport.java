package pl.krzysiek.tests.domain.helper;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseExport {
	public static void main(String[] args) throws Exception {
		Connection jdbcConnection = DriverManager.getConnection(
				"jdbc:mysql://localhost/tau", "root", "");

		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

		FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream(
				"src/test/resources/dataSet_.dtd"));

		FlatXmlDataSet.write(connection.createDataSet(), new FileOutputStream(
				"src/test/resources/fullData_.xml"));

	}

}
