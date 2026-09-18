public class computer {
	private String os, cpu;
	private int ram;
	private int fanCount;
	private double storage;
	private boolean hasBt,hasWifi,hasRGB,hasGamingGPU;
	
	public computer(){
		os="";
		cpu="";
		ram=0;
		storage=0;
		fanCount=0;
		hasBt=false;
		hasWifi=false;
		hasRGB=false;
		hasGamingGPU=false;
		
		
	}	
	
	public computer(String os, String cpu,int ram,double storage) {
		this.os=os;
		this.cpu=cpu;
		this.ram=ram;
		this.storage=storage;
		fanCount=0;
		hasBt=false;
		hasWifi=false;
		hasRGB=false;
		hasGamingGPU=false;
	}

	public computer(String os,String cpu) {
		this.os=os;
		this.cpu=cpu;
		ram=0;
		storage=0;
		fanCount=0;
		hasBt=false;
		hasWifi=false;
		hasRGB=false;
		hasGamingGPU=false;	
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getFanCount() {
		return fanCount;
	}

	public void setFanCount(int fanCount) {
		this.fanCount = fanCount;
	}

	public double getStorage() {
		return storage;
	}

	public void setStorage(double storage) {
		this.storage = storage;
	}

	public boolean isHasBt() {
		return hasBt;
	}

	public void setHasBt(boolean hasBt) {
		this.hasBt = hasBt;
	}

	public boolean isHasWifi() {
		return hasWifi;
	}

	public void setHasWifi(boolean hasWifi) {
		this.hasWifi = hasWifi;
	}

	public boolean isHasRGB() {
		return hasRGB;
	}

	public void setHasRGB(boolean hasRGB) {
		this.hasRGB = hasRGB;
	}

	public boolean isHasGamingGPU() {
		return hasGamingGPU;
	}

	public void setHasGamingGPU(boolean hasGamingGPU) {
		this.hasGamingGPU = hasGamingGPU;
	}
	@Override
	public String toString() {
		return "computer [os=" + os + ", cpu=" + cpu + ", ram=" + ram + ", fanCount=" + fanCount + ", storage="
				+ storage + ", hasBt=" + hasBt + ", hasWifi=" + hasWifi + ", hasRGB=" + hasRGB + ", hasGamingGPU="
				+ hasGamingGPU + "]";
	}
	

}