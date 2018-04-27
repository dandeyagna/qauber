package Max.Day11tasks;

import java.util.HashMap;

public class TestData {

	
	public static void main(String[] args) {
		HashMap<String, String> testData = new HashMap<String, String>();
		testData.put("CaseID", "C001");
		testData.put("SuspectType", "Suspect");
		testData.put("LastName", "Zinovskiy");
		testData.put("FirstName", "Max");
		testData.put("MiddleName", "V");
		testData.put("Nickname", "Maksim");
		testData.put("DOB", "01/01/01");
		testData.put("Age", "30");
		testData.put("Sex", "male");
		testData.put("Race", "caucasian");
		testData.put("Height", "5f11in");
		testData.put("Weight", "195lb");
		testData.put("Build", "Medium");
		testData.put("HairColor", "Blonde");
		testData.put("HairLength", "Short");
		testData.put("HairStyle", "Straight");
		testData.put("EyeColor", "Blue");
		testData.put("Complexion", "Light");
		testData.put("Teeth", "Gold");
		testData.put("HandPreference", "Right");
		testData.put("PrimaryLanguage", "English");
		testData.put("StreetAddress", "1234 Fake St.");
		testData.put("Country", "USA");
		testData.put("City", "abcd1234");
		testData.put("State", "abcd1234");
		testData.put("Zip", "abcd1234");
		testData.put("Telephone", "abcd1234");
		testData.put("E-Mail", "abcd1234");
		testData.put("RadioBox", "Pedestrian");
		
		System.out.println(testData.get("Age"));
		System.out.println(testData.get("Sex"));
		System.out.println(testData.get("Race"));
		System.out.println(testData.get("Height"));
		System.out.println(testData.get("Weight"));
	}
}
