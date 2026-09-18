package firstproject;

import java.net.InetAddress;
import java.net.Socket;

import java.io.*;
import java.util.Scanner;

public class basicclient {

	public static void main(String[] args) throws Exception, InterruptedException {
		Socket s = connectToServer();
        Scanner sc = correspondWithServer(s);
        disconnectFromServer(sc,s);
}

	public static Socket connectToServer() throws IOException, InterruptedException {
		// Use ipconfig (Windows) or ifconfig(Linux) to find the IP address
		// Change the IP address to that of your computer.
		int menu = 1;
		Scanner myInput = new Scanner(System.in);
        System.out.println("Port: ");
        int port = myInput.nextInt();
        System.out.println("IP: ");
        String ip = myInput.next();
        
		InetAddress inet = InetAddress.getByName(ip);// set up address of server
		// create socket using server ip address and port....
		Socket s = new Socket(inet, port);
		// wait patiently....
		Thread.sleep(200);
		// input from the socket (s)
		return s;

	}

	public static Scanner correspondWithServer(Socket s) throws IOException {
		int menu = 1;
		DataOutputStream writeToServer = new DataOutputStream(s.getOutputStream());
		
		writeToServer.writeByte(menu);

		// input from the socket (s)
		InputStream in = s.getInputStream();
		// scanner object to access the input
		Scanner scanner = new Scanner(in);
		// inputLine is the next (only) line in our "document"
		String inputLine = scanner.nextLine();

		System.out.println(inputLine);// print entire line

		//String[] data = inputLine.split(", ");// create array that splits on the space

		//System.out.println("name: " + data[0] + " address: " + data[1] + " = "+ data[2]);
		scanner.close();
		return scanner;

	}
	
	public static void disconnectFromServer(Scanner scanner, Socket s) throws IOException {
		scanner.close();
		s.close();
	}
}