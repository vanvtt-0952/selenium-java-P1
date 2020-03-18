package apt.configs.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;

import apt.util.ReadPropertiesFile;

public class DatabaseConfig {
	private static final Logger LOGGER = Logger.getLogger(DatabaseConfig.class);
	Connection con;

	public Statement connectDatabase() {
		ReadPropertiesFile properties = new ReadPropertiesFile();
		Properties prop = null;
		try {
			prop = properties.getPropValues("datasources.properties");
			Class.forName(prop.getProperty("mysql.driver"));
			String url = prop.getProperty("mysql.url");
			String user = prop.getProperty("mysql.user");
			String password = prop.getProperty("mysql.password");
			// Get connection to DB
			con = DriverManager.getConnection(url, user, password);
			return con.createStatement();
		} catch (IOException e) {
			LOGGER.error("Has exeption ", e);
		} catch (SQLException e) {
			LOGGER.error("Has exeption ", e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Has exeption ", e);
		}
		return null;
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}
}
