package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties pro = new Properties();

		InputStream readfile = null;
		try {
			readfile = new FileInputStream("config.properties");
			pro.load(readfile);
			System.out.println(pro.getProperty("url"));
			System.out.println(pro.getProperty("userName"));
			System.out.println(pro.getProperty("passwd"));

		} catch (IOException io) {
			// TODO Auto-generated catch block
			io.printStackTrace();
		} finally {
			if (readfile != null) {
				try {
					readfile.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}

	}

}
