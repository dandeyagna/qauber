package Max.Day17tasks;

import java.util.HashMap;

public class TestData {
	public String returnTestData(String key) {
		HashMap<String, String> testData = new HashMap<String, String>();
		testData.put("caseNumber", "C001");
		testData.put("SuspectType", "Suspect");
		testData.put("lastName", "Zinovskiy");
		testData.put("firstName", "Max");
		testData.put("middleName", "V");
		testData.put("Nickname", "Maksim");
		//testData.put("DOB", "01/01/01");
		testData.put("Age", "30");
		//testData.put("Sex", "male");
		//testData.put("Race", "caucasian");
		testData.put("Height", "511");
		testData.put("Weight", "1950");
		//testData.put("Build", "Medium");
		//testData.put("HairColor", "Blonde");
		//testData.put("HairLength", "Short");
		//testData.put("HairStyle", "Straight");
		//testData.put("EyeColor", "Blue");
		//testData.put("Complexion", "Light");
		//testData.put("Teeth", "Gold");
		//testData.put("HandPreference", "Right");
		testData.put("primary-language", "English");
		testData.put("street-address", "1234 Fake St.");
		//testData.put("Country", "USA");
		testData.put("city", "abcd1234");
		testData.put("state", "abcd1234");
		testData.put("zip", "abcd1234");
		testData.put("phone", "abcd1234");
		testData.put("email", "abcd1234");
		//testData.put("RadioBox", "Pedestrian");
		
		System.out.println(testData.get("Age"));
		//System.out.println(testData.get("Sex"));
		//System.out.println(testData.get("Race"));
		System.out.println(testData.get("Height"));
		System.out.println(testData.get("Weight"));
		return testData.get(key);
	}
}
