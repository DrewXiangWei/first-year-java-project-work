public class Pointtest{
	public static void main(String[] args) {
		Point point1=new Point(1,-4);
		Point point2=new Point(6,3);
		Point point3=new Point(-10,-8);
		double distance=point1.calculateDistance(point2)
					+point2.calculateDistance(point3)
					+point3.calculateDistance(1,1);
		System.out.println("Overall distance: "+distance);
	}
}