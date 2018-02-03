package functions;

public class FcnViewAsset {
	
	//FIXED ASSET
	public String idfa, idClass, idBrand, idSupplier, currLoc, idRcv;	 
	public String faCode, product, model, serialNo, barcode, manufacturer, license,  description, dateAdded,  dateUpdated, rcptInfo, datePurchase, dateWarranty, classification, brand, supplier, location; 
	public String assetLife, cost, salvageVal;
	
	
	public FcnViewAsset(String faCode, String product, String model, String brand, String classification, String manufacturer, String license, String serialNo, String barcode, String description, String supplier, String location, String cost, String assetLife, String salvageVal,  String datePurchase, String dateWarranty, String idfa, String idClass, String idBrand, String idSupplier, String currLoc, String idRcv){
		this.faCode = faCode; 
		this.product = product;
		this.model = model;
		this.brand = brand;
		this.classification = classification;
		this.manufacturer = manufacturer;
		this.license = license;
		this.serialNo = serialNo;
		this.barcode = barcode;
		this.description = description;
		this.supplier = supplier;
		this.location = location;
		this.cost = cost;
		this.assetLife = assetLife;
		this.salvageVal = salvageVal;
		this.datePurchase = datePurchase;
		this.dateWarranty = dateWarranty;
		this.idfa = idfa;
		this.idClass = idClass;
		this.idBrand = idBrand;
		this.idSupplier = idSupplier;
		this.currLoc = currLoc;
		this.idRcv = idRcv;
		
	}
	
	
	//Int
	public String getIdFa() {
		return idfa;
	}
	public void setIdFa(String idfa) {
		this.idfa = idfa;
	}
	
	public String getIdClass() {
		return idClass;
	}
	public void setIdClass(String idClass) {
		this.idfa = idClass;
	}
	
	public String getIdBrand() {
		return idBrand;
	}
	public void setIdBrand(String idBrand) {
		this.idBrand = idBrand;
	}
	
	public String getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(String idSupplier) {
		this.idSupplier = idSupplier;
	}
	
	public String getCurrLoc() {
		return currLoc;
	}
	public void setCurrLoc(String currLoc) {
		this.currLoc = currLoc;
	}
	
	public String getAssetLife() {
		return assetLife;
	}
	public void setAssetLife(String assetLife) {
		this.assetLife = assetLife;
	}
	
	public String getIdRcv() {
		return idRcv;
	}
	public void setIdRcv(String idRcv) {
		this.idRcv = idRcv;
	}
	
	
	//String
	public String getFaCode() {
		return faCode;
	}
	public void setFaCode(String faCode) {
		this.faCode = faCode;
	}
	
	public String getDdateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public String getDatePurchase() {
		return datePurchase;
	}
	public void setDatePurchase(String datePurchase) {
		this.datePurchase = datePurchase;
	}
	
	public String getDateWarranty() {
		return dateWarranty;
	}
	public void setDateWarranty(String dateWarranty) {
		this.dateWarranty = dateWarranty;
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
	
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
