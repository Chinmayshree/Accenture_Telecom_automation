package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteProperties {

	public static void main(String[] args) {

		Properties pro = new Properties();

		OutputStream writefile = null;

		try {

			writefile = new FileOutputStream("config.properties");// write file in Java

			pro.setProperty("url", "www.Google.com");
			pro.setProperty("userName", "Admin");
			pro.setProperty("passwd", "Admin123");
			pro.store(writefile, null);
			System.out.println("create Propeties successfully");

		} catch (IOException io) {
			io.printStackTrace();
			// System.out.println();
		} finally {
			if (writefile != null) {
				try {
					writefile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
