public class arraysinretailshop {
	public static void main(String[] args) {
		int[] productIds = new int[5];
		productIds[0] = 101;
		productIds[1] = 102;
		productIds[2] = 103;
		productIds[3] = 104;
		productIds[4] = 105;

		String[]productNames={"Laptop", "Smartphone", 
				"Headphones", "Tablet", "AirPods"};
		double[]productPrices={899.99,499.99,79.99, 
				299.99,300};
		int[]quantitiesInStock={15, 30, 50, 20, 10};
		
		String orderItem = "Laptop";
		int orderedQuantity = 2;
		int itemIndex = -1;

		System.out.println("Before update:");
		for (int i = 0; i < productNames.length; i++) {
			System.out.printf("%4d,%10s,%8.2fâ‚¬,%4d\n",
					productIds[i],productNames[i],
					productPrices[i],quantitiesInStock[i]);
		}
		for(int i = 0; i < productNames.length; i++) {
			if(productNames[i].equals(orderItem)) {
				itemIndex = i;
				break;
			}
		}
		int curentInventory=quantitiesInStock[itemIndex];
		if (curentInventory > orderedQuantity) {
		quantitiesInStock[itemIndex]=curentInventory - orderedQuantity;
		}
		System.out.println("\nAfter update:");
		for (int i = 0; i < productNames.length; i++) {
			System.out.printf("%4d,%10s,%8.2fâ‚¬,%4d\n"
				,productIds[i],productNames[i]
				,productPrices[i],quantitiesInStock[i]);
		}
	}
}
