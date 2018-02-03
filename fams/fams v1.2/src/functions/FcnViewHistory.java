package functions;

public class FcnViewHistory {
	
	//FIXED ASSET 
	public String faCode, product, model, serialNo, barcode, location, inCharge, dateAdded, dateUpdated, transaction, transId, transNo, transInCharge, transDate; 

	
	
	public FcnViewHistory(String transNo, String transaction, String faCode, String product, String serialNo, String barcode, String transDate, String location, String inCharge){
		this.transNo = transNo; 
		this.transaction = transaction;
		this.faCode = faCode; 
		this.product = product;
		this.serialNo = serialNo;
		this.barcode = barcode;
		this.transDate = transDate; 
		this.location = location;
		this.inCharge = inCharge;
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
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getInCharge() {
		return inCharge;
	}
	public void getInCharge(String inCharge) {
		this.inCharge = inCharge;
	}
	
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	
	public String getTransNo() {
		return transNo;
	}
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}
	
	public String getTransInCharge() {
		return transInCharge;
	}
	public void setTransInCharge(String transInCharge) {
		this.transInCharge = transInCharge;
	}
	
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
