//class for the Entities page
public class EntitiesPage {
	//attributes derived from each element on the page
	private String addEntityXpath;
	private String firstEntityXpath;
	private String assPermissionsXpath; //assign permissions...
	private String editEntityXpath;
	private String deleteEntityXpath;
	//constructor to initialize attributes
	public EntitiesPage(String addEntityXpath, String firstEntityXpath, String assPermissionsXpath, String editEntityXpath, String deleteEntityXpath) {
		this.addEntityXpath = addEntityXpath;
		this.firstEntityXpath = firstEntityXpath;
		this.assPermissionsXpath = assPermissionsXpath;
		this.editEntityXpath = editEntityXpath;
		this.deleteEntityXpath = deleteEntityXpath;
	}
	
	public void clickAddEntity(String addEntityXpath){
		//click Add Entity button
	}
	
	public void clickFirstEntity(String firstEntityXpath) {
		//click on the first Entity in the list
	}
	
	public void clickAssPermissions(String assPermissionsXpath) {
		//click on the Assign Permissions button
	}
	
	public void clickEditEntity(String editEntityXpath) {
		//click on the Edit entity button for the first entity
	}
	
	public void deleteEntity(String deleteEntityXpath) {
		//click on the Delete entity button for the first entity
	}
	
}
