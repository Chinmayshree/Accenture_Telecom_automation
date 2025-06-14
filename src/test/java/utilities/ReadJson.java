package utilities;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		String filepath = System.getProperty("user.dir") + "//testData.json";
		FileReader file = new FileReader(filepath);
		JSONParser parse = new JSONParser();
		JSONObject json = (JSONObject) parse.parse(file);
		System.out.println(json.toJSONString());
		JSONArray testdata = (JSONArray) json.get("studentInfo");
		System.out.println(testdata.toJSONString());

		JSONObject test1 = (JSONObject) testdata.get(0);
		System.out.println(test1.toJSONString());
		String stuName = (String) test1.get(1);
		System.out.println(stuName);

		JSONObject test2 = (JSONObject) testdata.get(1);
		System.out.println(test2.toJSONString());

		for (int i = 0; i < testdata.size(); i++) {

		}

	}

}
