package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject student1 = new JSONObject();
		student1.put("studentName", "Chinmay");
		student1.put("RollNo", 102);
		student1.put("City", "Pune");

		JSONObject student2 = new JSONObject();
		student2.put("studentName", "hari");
		student2.put("RollNo", 103);
		student2.put("City", "Pune");
		System.out.println(student1.toJSONString());
		System.out.println(student2.toJSONString());

		JSONArray studentDetails = new JSONArray();
		studentDetails.add(student1);
		studentDetails.add(student2);
		System.out.println(studentDetails.toJSONString());

		JSONObject studentInfo = new JSONObject();
		studentInfo.put("studentInfo", studentDetails);
		System.out.println(studentInfo.toJSONString());

	}

}
