import java.util.Scanner;
public class computerTestClass {

	public static void main(String[] args) {
		computer c1=new computer();
//public computer(String os, String cpu,int ram,double storage)
		computer c2=new computer("Windows","AMD",32000,1000);
		computer c3=new computer("MacintOsh","ARM");
		
		Scanner in=new Scanner(System.in);
		
		System.out.println(c1.toString());
		System.out.println(c2);
		System.out.println(c3);
		
	}
	
}
