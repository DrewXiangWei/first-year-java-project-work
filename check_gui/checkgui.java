package check_gui;

import java.net.InetAddress;
import java.net.Socket;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class checkgui implements ActionListener {

	JFrame window = new JFrame("Event listener");

	JPanel panel = new JPanel();
	JButton buttonAverageTemp = new JButton("Get Average Temp");
	JButton buttonMaxTemp = new JButton("Get Maximum Temp");
	JButton buttonMinTemp = new JButton("Get Minimum Temp");
	JButton buttonAverageHumid = new JButton("Get Average Humidity");
	JButton buttonMaxHumid = new JButton("Get Maximum Humidity");
	JButton buttonMinHumid = new JButton("Get Minimum Humidity");
	JLabel label = new JLabel("No button Pressed");

	public checkgui() {

		buttonAverageTemp.setPreferredSize(new Dimension(200, 100));
		buttonMinTemp.setPreferredSize(new Dimension(200, 100));
		buttonMaxTemp.setPreferredSize(new Dimension(200, 100));
		buttonAverageHumid.setPreferredSize(new Dimension(200, 100));
		buttonMinHumid.setPreferredSize(new Dimension(200, 100));
		buttonMaxHumid.setPreferredSize(new Dimension(200, 100));
		label.setPreferredSize(new Dimension(200, 100));

		buttonAverageTemp.addActionListener(this);
		buttonMinTemp.addActionListener(this);
		buttonMaxTemp.addActionListener(this);
		buttonAverageHumid.addActionListener(this);
		buttonMinHumid.addActionListener(this);
		buttonMaxHumid.addActionListener(this);

		panel.add(buttonAverageTemp);
		panel.add(buttonMinTemp);
		panel.add(buttonMaxTemp);
		panel.add(buttonAverageHumid);
		panel.add(buttonMinHumid);
		panel.add(buttonMaxHumid);
		panel.add(label);

		window.getContentPane().add(panel);
		window.setSize(1000, 1200);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) throws Exception, InterruptedException {

		checkgui client = new checkgui();

	}
	@Override
	public void actionPerformed(ActionEvent e) {

		// When button pressed, get value from server according to button pressed
		// "1" means getAverage
		// "2" means getMaximum
		// "3" means getMinimum ... not coded yet

		if (e.getSource().equals(buttonAverageTemp)) {

			try {
				label.setText("Average button was pressed");
				System.out.println("In Try");
				
				
				Socket s = connectToServer();
				String[] data = correspondWithServer(s, "1");

				
				double average = getAvg(data);
				if (average < 5) {
					panel.setBackground(Color.blue);
				} else if (average > 30) {
					panel.setBackground(Color.red);
				} else if ((average > 5) & (average < 30)) {
					panel.setBackground(Color.green);
				}
				System.out.println("Average:"+ average);
				System.out.println();


			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource().equals(buttonMinTemp)) {
			label.setText("Minimum button was pressed");

			try {
				Socket s = connectToServer();
				String[] data = correspondWithServer(s, "2");
				double min = getMin(data);
				if (min < 5) {
					panel.setBackground(Color.blue);
				} else if (min > 30) {
					panel.setBackground(Color.red);
				} else if ((min > 5) & (min < 30)) {
					panel.setBackground(Color.green);
				}
				System.out.println("Minimum:" + min);

			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(buttonMaxTemp)) {
			label.setText("Maximum button was pressed");
			
			try {
				Socket s = connectToServer();
				String[] data = correspondWithServer(s, "3");
				double max = getMax(data);
				if (max < 5) {
					panel.setBackground(Color.blue);
				} else if (max > 30) {
					panel.setBackground(Color.red);
				} else if ((max > 5) & (max < 30)) {
					panel.setBackground(Color.green);
				}
				System.out.println("Maximum: "+ max);

			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		
		else if (e.getSource().equals(buttonAverageHumid)) {

			try {
				label.setText("Average button was pressed");
				System.out.println("In Try");
				
				
				Socket s = connectToServer();
				String[] data = correspondWithServer(s, "4");

				
				double average = getAvg(data);
				if (average < 5) {
					panel.setBackground(Color.blue);
				} else if (average > 30) {
					panel.setBackground(Color.red);
				} else if ((average > 5) & (average < 30)) {
					panel.setBackground(Color.green);
				}
				System.out.println("Average:"+ average);
				System.out.println();


			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}

		} else if (e.getSource().equals(buttonMinHumid)) {
			label.setText("Minimum button was pressed");

			try {
				Socket s = connectToServer();
				String[] data = correspondWithServer(s, "5");
				double min = getMin(data);
				if (min < 5) {
					panel.setBackground(Color.blue);
				} else if (min > 30) {
					panel.setBackground(Color.red);
				} else if ((min > 5) & (min < 30)) {
					panel.setBackground(Color.green);
				}
				System.out.println("Minimum:" + min);

			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource().equals(buttonMaxHumid)) {
			label.setText("Maximum button was pressed");
			
			try {
				Socket s = connectToServer();
				String[] data = correspondWithServer(s, "6");
				double max = getMax(data);
				if (max < 5) {
					panel.setBackground(Color.blue);
				} else if (max > 30) {
					panel.setBackground(Color.red);
				} else if ((max > 5) & (max < 30)) {
					panel.setBackground(Color.green);
				}
				System.out.println("Maximum: "+ max);

			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	

	public static Socket connectToServer() throws IOException, InterruptedException {
		// Use ipconfig (Windows) or ifconfig(Linux) to find the IP address
		// Change the IP address to that of your computer.
		InetAddress inet = InetAddress.getByName("192.168.147.88");// set up address of server
		// create socket using server ip address and port....
		Socket s = new Socket(inet, 2003);
		// wait patiently....
		Thread.sleep(200);
		// input from the socket (s)
		return s;

	}

	public static String[] correspondWithServer(Socket s, String menu) throws IOException {
		// String menu = "1";
		DataOutputStream writeToServer = new DataOutputStream(s.getOutputStream());
		writeToServer.writeBytes(menu);
		// input from the socket (s)
		InputStream in = s.getInputStream();
		// scanner object to access the input
		Scanner scanner = new Scanner(in);
		// inputLine is the next (only) line in our "document"
		String inputLine = scanner.nextLine();

		System.out.println(inputLine);// print entire line

		String[] data = inputLine.split(" ");// create array that splits on the space

		disconnectFromServer(scanner,s);  // disconnect Socket and Scanner
		return data;

	}

	public static double getAvg(String[] data) {
		double total = 0.0;
		for (String item : data) {
			total += Double.valueOf(item);
		}
		return total / data.length;

	}
	
	public static double getMin(String[] data) {
		double min=900;
		for (String item : data) {
			double value = Double.valueOf(item);
			if(value < min) {
				min = value;
			}
		}
		return min;
	}
	public static double getMax(String[] data) {
		double max = 0;
		for (String item : data) {
			double value = Double.valueOf(item);
			if(value > max) {
				max = value;
			}
		}
		return max;
	}

	public static void disconnectFromServer(Scanner scanner, Socket s) throws IOException {
		scanner.close();
		s.close();
	}
}