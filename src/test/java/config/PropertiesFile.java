package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	static Properties prop = new Properties();
	public static void main(String[] args) {
		readPropertiesFile();
	}
	
	public static void readPropertiesFile() {
		
		try {
			InputStream input = new FileInputStream("C:\\Users\\PRASHANT\\eclipse-workspace\\demo\\src\\test\\java\\config\\config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("browser"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

