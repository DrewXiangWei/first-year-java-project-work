public class Point {
	//fields
	private double x,y;
	private String name,description;
	//constructors
	public Point() {}
	public Point(double x, double y) {
		this.x=x;
		this.y=y;
	}
	public Point(double x, double y,String name,String description){
		this.x=x;
		this.y=y;
		this.name=name;
		this.description=description;
	}
	public String getname(){
		return name;
	}
	public void setname(String name){
		this.name=name;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double calculateDistance(Point point) {
		return calculateDistance(point.getX(),point.getY());
	}
	public double calculateDistance(double x,double y) {
		double distance=0;
		double x1=this.x;
		double y1=this.y;
		double xdifsquared=Math.pow(x - x1,2);
		double ydifsquared=Math.pow(y - y1,2);
		double sumdifsquaered=xdifsquared + ydifsquared;
		distance=Math.sqrt(sumdifsquaered);
		return distance;
	}
}
