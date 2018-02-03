package functions;

public class FcnViewDepreciation {
	
	//FIXED ASSET 
	public String faCode, product, model, classification, brand; 
	public String assetLife, cost, salvageVal, depVal;
	
	
	public FcnViewDepreciation(String faCode, String product, String model, String classification, String cost, String assetLife, String salvageVal, String depVal){
		this.faCode = faCode; 
		this.product = product;
		this.model = model;
		this.classification = classification;
		this.cost = cost;
		this.assetLife = assetLife;
		this.salvageVal = salvageVal;
		this.depVal = depVal;
				
	}
	
	public String getDepVal() {
		return depVal;
	}
	public void setDepVal(String depVal) {
		this.depVal = depVal;
	}
	
	public String getAssetLife() {
		return assetLife;
	}
	public void setAssetLife(String assetLife) {
		this.assetLife = assetLife;
	}
	
	//String
	public String getFaCode() {
		return faCode;
	}
	public void setFaCode(String faCode) {
		this.faCode = faCode;
	}
	
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	//DOUBLE
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	public String getSalvageVal() {
		return salvageVal;
	}
	public void setSalvageVal(String salvageVal) {
		this.salvageVal = salvageVal;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
