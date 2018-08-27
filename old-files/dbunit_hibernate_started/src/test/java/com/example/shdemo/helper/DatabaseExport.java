package com.example.shdemo.helper;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class DatabaseExport {
	public static void main(String[] args) throws Exception {
		Connection jdbcConnection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/workdb", "sa", "");

		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

		FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream(
				"src/test/resources/dataSet_.dtd"));
		
		FlatXmlDataSet.write(connection.createDataSet(), new FileOutputStream(
				"src/test/resources/fullData_.xml"));

	}

}
