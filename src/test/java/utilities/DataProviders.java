package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	public ExcelUtility utility;
	String path = ".\\testData\\OpencartLoginData.xlsx";

	@DataProvider(name = "LoginData")
	public String[][] getLoginData() throws IOException {

		utility = new ExcelUtility(path);

		int totalRows = utility.getRowCount("sheet1");
		int totalCols = utility.getCellCount("sheet1", 1);

		System.out.println(totalRows);
		System.out.println(totalCols);

		String[][] logindata = new String[totalRows][totalCols];

		for (int i = 1; i <= totalRows; i++) {

			for (int j = 0; j < totalCols; j++) {
				logindata[i - 1][j] = utility.getCellData("sheet1", i, j);
			}
		}

		return logindata;
	}

}
