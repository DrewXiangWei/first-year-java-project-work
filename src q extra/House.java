public class House {
	int doors;
	int windows;
	int chimneys;
	int floors;
	int rooms;
	String address;
	public int getfloors() {return floors;}
	public void setFloors(int floors) {
		this.floors=floors;}
	public int getDoors() {return doors;}
	public void setDoors(int doors) {
		this.doors = doors;}
	public int getWindows() {return windows;}
	public void setWindows(int windows) {
		this.windows = windows;}
	public int getChimneys() {return chimneys;}
	public void setChimneys(int chimneys) {
		this.chimneys = chimneys;}
	public int getRooms() {return rooms;}
	public void setRooms(int rooms) {
		this.rooms = rooms;}
	public String getAddress() {return address;}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
	return "House [doors=" + doors + ", windows=" + windows 
	+ ", chimneys=" + chimneys + ", floors=" + floors
	+ ", rooms=" + rooms + ", address=" + address + "]";
	}
	

}
