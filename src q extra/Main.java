public class Main {
	public static void main(String[] args) {
	//create house object 
	House house1=new House();
	house1.setAddress("2 BAY, Knowhere, The Rip");
	house1.setChimneys(4);
	house1.setDoors(1);
	house1.setFloors(1);
	house1.setRooms(3);
	house1.setWindows(0);
	System.out.println(house1.toString());
	}
}
