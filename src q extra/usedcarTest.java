
public class usedcarTest {

	public static void main(String[] args) {
	usedcar[] cars= {new usedcar("Toyota","CH-R",45000,1.8,2021,28000),
		new usedcar("Audi","A3",150000,1.5,2018,14000),
		new usedcar("FastCar","Crimera",5000,3.5,2020,380000),
		new usedcar("VW","Passat",450000,2,2015,6000),
		new usedcar("Peguot","206WR",3000,2.5,2020,280000),
		new usedcar("Porche","911 Turbo",150000,3.2,1995,120000)
		};
	for(int i=0;i<cars.length;i++) {
		System.out.println(cars[i].toString()); 
	}
	usedcar cheapest=cars[0];
	for(int i=1;i<cars.length; i++) {
		usedcar car=cars[i];			
		if(car.getPrice()<cheapest.getPrice()) {
			cheapest=car;
		}
	}
	usedcar mostEco = cars[0];
	double distance = 100;
	
	for(int i=1;i<cars.length; i++) {
		usedcar car=cars[i];
		
		double carConsumption =car.calculateFuelConsumption(distance);
		
		double mostEcoConsumption = mostEco
				.calculateFuelConsumption(distance);
		
		if(carConsumption < mostEcoConsumption) {
			mostEco = car;
		}
	}
	
	System.out.println();
	System.out.println("Most eco car is:\n"+mostEco);
	
	System.out.println();
	System.out.println("Cheapest car is:\n"+cheapest);
	}

}
