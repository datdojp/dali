package vn.kohana.mst;

public class CategoryMst extends BaseMst {
	private String name;
	private String image;
	private String supcatCode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSupcatCode() {
		return supcatCode;
	}
	public void setSupcatCode(String supcatCode) {
		this.supcatCode = supcatCode;
	}
}
