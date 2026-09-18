import java.util.Scanner;
public class loops {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int userChoice =0;
		do{
			System.out.print("Enter Date 1:");
			int date1 =keyboard.nextInt();
			System.out.print("Enter Date 2:");
			int date2 =keyboard.nextInt();
			for (int i=date1&date2; i<=365; i++) 
			{
				System.out.print("Days :" + i);
			}
			System.out.print("Enter 1 to repeat :");
			userChoice = keyboard.nextInt();}
		while(userChoice == 1);
		System.out.println("Program Finished");
		// TODO Auto-generated method stub
	}
}
