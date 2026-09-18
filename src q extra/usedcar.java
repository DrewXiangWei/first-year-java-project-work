
public class usedcar {
	private String make,model;
	private int year;
	private double price,millage,enginesize;

	public usedcar(String make,String model,int year
	,double millage,double enginesize,double price) {
		this.make=make;
		this.model=model;
		this.year=year;
		this.price=price;
		this.millage=millage;
		this.enginesize=enginesize;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMillage() {
		return millage;
	}
	public void setMillage(double millage) {
		this.millage = millage;
	}
	public double getEnginesize() {
		return enginesize;
	}
	public void setEnginesize(double enginesize) {
		this.enginesize = enginesize;
	}
	@Override
	public String toString() {
		return "usedcar [make=" + make + ", model=" + model + ", year=" + year + ", price=" + price + ", millage="
		+ millage + ", enginesize=" + enginesize + "]";
	}
	public double calculateFuelConsumption(double kmTraveled) {
		double consumtionPer1l=5;
		double consumtion=consumtionPer1l*enginesize*(kmTraveled/100);
		return consumtion;
	}
}
