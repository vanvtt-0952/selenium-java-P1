package apt.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadPropertiesFile {

	private static final Logger LOGGER = Logger.getLogger(ReadPropertiesFile.class);

	public Properties getPropValues(String nameFile) throws IOException {
		InputStream inputStream = null;

		Properties prop = new Properties();
		try {

			inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);

			if (inputStream != null) {
				prop.load(inputStream);
				LOGGER.info("read file properties");
			} else {
				LOGGER.error("file not found in the classpath");
				throw new FileNotFoundException("property file '" + nameFile + "' not found in the classpath");
			}

		} catch (Exception e) {
			LOGGER.error("Has exeption ", e);
		} finally {
			inputStream.close();
		}
		return prop;
	}
}
